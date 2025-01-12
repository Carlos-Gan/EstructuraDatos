package expresion;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Infix {

    private JLabel lblTipoExp;

    public Infix(JLabel lblTipoExp) {
        this.lblTipoExp = lblTipoExp;
    }

    // Function to find precedence of operators
    public static int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        }
        if (op == '*' || op == '/') {
            return 2;
        }
        if (op == '^') {
            return 3;
        }
        return 0;
    }

    // Function to perform arithmetic operations
    public static int applyOp(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("División por cero");
                }
                return a / b;
            case '^':
                return (int) Math.pow(a, b);
        }
        throw new IllegalArgumentException("Operador inválido: " + op);
    }

    // Function that returns the value of the expression after evaluation
    public static int evaluate(String tokens) {
        int i = 0;

        // Stack to store integer values
        Stack<Integer> values = new Stack<>();

        // Stack to store operators
        Stack<Character> ops = new Stack<>();

        // Map to store values of variables
        Map<Character, Integer> variableValues = new HashMap<>();

        while (i < tokens.length()) {
            char currentChar = tokens.charAt(i);

            // Skip whitespaces
            if (currentChar == ' ') {
                i++;
                continue;
            } // Current token is an opening brace, push it to 'ops'
            else if (currentChar == '(') {
                ops.push(currentChar);
            } // Current token is a number, push it to the stack
            else if (Character.isDigit(currentChar)) {
                int val = 0;

                // There may be more than one digit in the number
                while (i < tokens.length() && Character.isDigit(tokens.charAt(i))) {
                    val = (val * 10) + (tokens.charAt(i) - '0');
                    i++;
                }

                values.push(val);

                // Since the for loop also increases the index, we need to decrease it by 1
                i--;
            } else if (Character.isLetter(currentChar)) {
                if (!variableValues.containsKey(currentChar)) {
                    String input = JOptionPane.showInputDialog(null,
                            "¿Qué valor tiene la variable '" + currentChar + "'?",
                            "Entrada de variable",
                            JOptionPane.QUESTION_MESSAGE);
                    if (input == null || input.isEmpty()) {
                        throw new IllegalArgumentException("Se canceló la entrada o no se ingresó un valor para la variable '" + currentChar + "'");
                    }
                    int val;
                    try {
                        val = Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Valor inválido ingresado para la variable '" + currentChar + "'");
                    }
                    variableValues.put(currentChar, val);
                }
                values.push(variableValues.get(currentChar));
            } // Closing brace encountered, solve the entire brace
            else if (currentChar == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    int val2 = values.pop();
                    int val1 = values.pop();
                    char op = ops.pop();

                    values.push(applyOp(val1, val2, op));
                }

                // Pop opening brace
                if (!ops.isEmpty()) {
                    ops.pop();
                }
            } // Current token is an operator
            else {
                // While top of 'ops' has same or greater precedence to current token
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(currentChar)) {
                    int val2 = values.pop();
                    int val1 = values.pop();
                    char op = ops.pop();

                    values.push(applyOp(val1, val2, op));
                }

                // Push current token to 'ops'
                ops.push(currentChar);
            }

            i++;
        }

        // Apply remaining ops to remaining values
        while (!ops.isEmpty()) {
            int val2 = values.pop();
            int val1 = values.pop();
            char op = ops.pop();

            values.push(applyOp(val1, val2, op));
        }

        // Top of 'values' contains the result, return it
        return values.pop();
    }

    // Validar Expresión Infija
    public boolean esInfijaValida(String exp) {
    // Pila para almacenar los paréntesis
    Stack<Character> stack = new Stack<>();

    // Separar la expresión en sus componentes
    String[] tokens = separarTokens(exp);

    // Variables para validar la relación entre operadores y operandos
    int contadorOperandos = 0;
    boolean operadorEncontrado = false; // Variable para verificar si hay al menos un operador

    // Recorrer la expresión
    for (int i = 0; i < tokens.length; i++) {
        String token = tokens[i];
        char c = token.charAt(0); // Tomamos el primer carácter de cada token

        // Verificar paréntesis balanceados
        if (c == '(') {
            stack.push(c);
        } else if (c == ')') {
            if (stack.isEmpty()) {
                lblTipoExp.setText("Error: Paréntesis de cierre sin apertura.");
                return false; // Paréntesis desbalanceados
            }
            stack.pop();
        }

        // Verificar si el token es un número o una variable
        if (Character.isDigit(c) || Character.isLetter(c)) {
            contadorOperandos++; // Incrementar el contador de operandos
        }

        // Verificar si el token es un operador
        else if ("+-*/^".indexOf(c) != -1) {
            operadorEncontrado = true; // Se encontró un operador

            // Verificar si el operador está al principio o al final
            if (i == 0) {
                lblTipoExp.setText("Error: La expresión no puede comenzar con un operador.");
                return false;
            }
            if (i == tokens.length - 1) {
                lblTipoExp.setText("Error: La expresión no puede terminar con un operador.");
                return false;
            }

            // Verificar que haya suficientes operandos para el operador
            if (contadorOperandos < 1) {
                lblTipoExp.setText("Error: Faltan operandos para el operador '" + c + "'.");
                return false;
            }

            // Restar uno al contador porque el operador consume dos operandos
            contadorOperandos--;
        }
    }

    // Al final, la pila de paréntesis debe estar vacía (paréntesis balanceados)
    if (!stack.isEmpty()) {
        lblTipoExp.setText("Error: Paréntesis de apertura sin cierre.");
        return false;
    }

    // Verificar que al menos haya un operador
    if (!operadorEncontrado) {
        lblTipoExp.setText("Error: La expresión no contiene un operador válido.");
        return false;
    }

    // Verificar que al final haya exactamente un operando en el contador
    if (contadorOperandos != 1) {
        lblTipoExp.setText("Error: La expresión no es válida. Verifique operadores y operandos.");
        return false;
    }

    // Si todo es válido
    lblTipoExp.setText("Expresión válida.");
    return true;
}

    // Método para separar la expresión en tokens (números, operadores y paréntesis)
    public static String[] separarTokens(String input) {
        // Usar una expresión regular para separar números, letras, operadores y paréntesis
        // Ahora la expresión regular maneja números de varios dígitos correctamente
        Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]+|[-+*/()^]");
        Matcher matcher = pattern.matcher(input);

        // Crear una lista de tokens encontrados
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            sb.append(matcher.group()).append(" ");
        }

        // Devolver los tokens separados en un arreglo
        return sb.toString().trim().split("\\s+");
    }

}
