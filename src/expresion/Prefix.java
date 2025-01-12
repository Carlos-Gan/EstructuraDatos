package expresion;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Prefix {

    JLabel lblTipoExp;
    
    public Prefix ( JLabel lblTipoExp){
        this.lblTipoExp = lblTipoExp;
    }
    
    static boolean isdigit(char ch) {
        if (ch >= 48 && ch <= 57) {
            return true;
        }
        return false;
    }

    static double evaluatePrefix(String exprsn) {
        Stack<Double> stack = new Stack<Double>();
        Map<Character, Double> variableValues = new HashMap<>();

        for (int j = exprsn.length() - 1; j >= 0; j--) {

            char currentChar = exprsn.charAt(j);
            if (currentChar == ' ') {
                continue;
            }

            if (isdigit(currentChar)) {

                double num = 0, i = j;

                while (j > 0 && isdigit(exprsn.charAt(j))) {
                    j--;
                }
                j++;

                // from [j, i] exprsn contains a number
                for (int k = j; k <= i; k++) {
                    num = num * 10 + (double) (exprsn.charAt(k) - '0');
                }

                stack.push(num);
            } else if (Character.isLetter(currentChar)) {
                if (!variableValues.containsKey(currentChar)) {
                    String input = JOptionPane.showInputDialog(null,
                            "¿Qué valor tiene la variable '" + currentChar + "'?",
                            "Entrada de variable",
                            JOptionPane.QUESTION_MESSAGE);
                    if (input == null || input.isEmpty()) {
                        throw new IllegalArgumentException("Se canceló la entrada o no se ingresó un valor para la variable '" + currentChar + "'");
                    }

                    double value;
                    try {
                        value = Double.parseDouble(input); // Convert input to a double
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Valor inválido ingresado para la variable '" + currentChar + "'");
                    }
                    variableValues.put(currentChar, value);
                }
                stack.push(variableValues.get(currentChar));
            } else {
                double o1 = stack.pop();
                double o2 = stack.pop();

                switch (currentChar) {
                    case '+':
                        stack.push(o1 + o2);
                        break;
                    case '-':
                        stack.push(o1 - o2);
                        break;
                    case '*':
                        stack.push(o1 * o2);
                        break;
                    case '/':
                        if (o2 == 0) {
                            throw new ArithmeticException("División por cero");
                        }
                        stack.push(o1 / o2);
                        break;
                    case '^':
                        stack.push(Math.pow(o1, o2));
                        break;
                    default:
                        throw new IllegalArgumentException("Operador desconocido: " + currentChar);
                }
            }
        }
        return stack.peek();
    }
    
     public boolean esPrefijaValida(String exp) {
        // Verificar si los paréntesis están balanceados
        if (!paréntesisBalanceados(exp)) {
            lblTipoExp.setText("Error: Los paréntesis no están balanceados.");
            return false;
        }

        // Pila para manejar los operandos
        Stack<Integer> stack = new Stack<>();

        // Separar la expresión en sus componentes (tokens)
        String[] tokens = separarTokens(exp);

        // Recorrer los tokens en orden inverso (para la notación prefija)
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            // Si el token es un número o una variable, lo apilamos
            if (esNumero(token) || esVariable(token)) {
                stack.push(1); // Apilamos un operando
            } else if ("+-*/^".contains(token)) {
                // Si el token es un operador, necesitamos al menos dos operandos en la pila
                if (stack.size() < 2) {
                    lblTipoExp.setText("Error: Faltan operandos para el operador '" + token + "'");
                    return false;  // No hay suficientes operandos
                }
                // Aplicamos el operador (aunque no lo hacemos realmente)
                stack.pop();  // Primer operando
                stack.pop();  // Segundo operando
                stack.push(1); // Apilamos el resultado de la operación
            } else {
                // Si el token no es un número, una variable o un operador válido
                lblTipoExp.setText("Error: El token '" + token + "' no es válido.");
                return false;
            }
        }

        // Al final, solo debe quedarnos un operando en la pila
        if (stack.size() != 1) {
            lblTipoExp.setText("Error: Quedan operandos sin operar.");
            return false;
        }

        // La expresión es válida
        return true;
    }
     
     
     public static boolean paréntesisBalanceados(String exp) {
        Stack<Character> stack = new Stack<>();
        for (char c : exp.toCharArray()) {
            if (c == '(') {
                stack.push(c);  // Apilamos un paréntesis de apertura
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;  // Paréntesis de cierre sin apertura correspondiente
                }
                stack.pop();  // Eliminamos el paréntesis de apertura
            }
        }
        return stack.isEmpty();  // Si la pila está vacía, los paréntesis están balanceados
    }

    // Método para verificar si el token es un número
    public static boolean esNumero(String token) {
        try {
            Integer.parseInt(token);  // Intentar convertir el token a un número
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    // Método para verificar si el token es una variable (letra)
    public static boolean esVariable(String token) {
        return token.matches("[a-zA-Z]");  // Comprobar si el token es una letra
    }

    // Método para separar la expresión en tokens (números, letras y operadores)
    public static String[] separarTokens(String input) {
        // Usar una expresión regular para separar números, letras y operadores
        Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]+|[-+*/^]");
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