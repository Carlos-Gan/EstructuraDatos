package expresion;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Postfix {

    JLabel lblTipoExp;

    public Postfix(JLabel lblTipoExp) {
        this.lblTipoExp = lblTipoExp;
    }

    // Evalúa una expresión posfija dada y retorna el resultado
    public static int postfixEvaluate(String exp) {
        Stack<Integer> s = new Stack<>();
        Scanner tokens = new Scanner(exp);
        Map<String, Integer> variableValues = new HashMap<>(); // Para almacenar valores de variables

        while (tokens.hasNext()) {
            if (tokens.hasNextInt()) {
                s.push(tokens.nextInt());
            } else {
                String token = tokens.next();
                if (isOperator(token)) {
                    if (s.size() < 2) {
                        throw new IllegalArgumentException("Error: No hay suficientes operandos para el operador '" + token + "'.");
                    }
                    int num1 = s.pop();
                    int num2 = s.pop();
                    s.push(applyOperator(num2, num1, token)); // Atención al orden (num2, num1)
                } else if (esVariable(token)) {
                    if (!variableValues.containsKey(token)) {
                        String input = JOptionPane.showInputDialog(null,
                                "¿Qué valor tiene la variable '" + token + "'?",
                                "Entrada de variable",
                                JOptionPane.QUESTION_MESSAGE);
                        if (input == null || input.isEmpty()) {
                            throw new IllegalArgumentException("Error: No se ingresó un valor para la variable '" + token + "'.");
                        }
                        try {
                            variableValues.put(token, Integer.parseInt(input));
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("Error: Valor inválido ingresado para la variable '" + token + "'.");
                        }
                    }
                    s.push(variableValues.get(token));
                } else {
                    throw new IllegalArgumentException("Error: Token inválido '" + token + "'.");
                }
            }
        }

        if (s.size() != 1) {
            throw new IllegalArgumentException("Error: La expresión posfija no es válida. Verifica los operandos y operadores.");
        }
        return s.pop();
    }

    private static boolean isOperator(String token) {
        return "+-*/^".contains(token);
    }

    private static int applyOperator(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Error: División por cero.");
                }
                return num1 / num2;
            case "^":
                return (int) Math.pow(num1, num2);
            default:
                throw new IllegalArgumentException("Operador inválido: " + operator);
        }
    }

    // Valida si una expresión posfija es válida
    public boolean esPosfijaValida(String exp) {
        if (exp.contains("(") || exp.contains(")")) {
            lblTipoExp.setText("Error: Los paréntesis no son válidos en una expresión posfija.");
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        String[] tokens = separarTokens(exp);

        for (String token : tokens) {
            if (esNumero(token) || esVariable(token)) {
                stack.push(1);
            } else if (isOperator(token)) {
                if (stack.size() < 2) {
                    lblTipoExp.setText("Error: Faltan operandos para el operador '" + token + "'.");
                    return false;
                }
                stack.pop();
                stack.pop();
                stack.push(1);
            } else {
                lblTipoExp.setText("Error: Token inválido '" + token + "'.");
                return false;
            }
        }

        if (stack.size() != 1) {
            lblTipoExp.setText("Error: La expresión posfija no es válida. Quedan operandos sin operar.");
            return false;
        }

        lblTipoExp.setText("Expresión posfija válida.");
        return true;
    }

    public static boolean esNumero(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean esVariable(String token) {
        return token.matches("[a-zA-Z]");
    }

    public static String[] separarTokens(String input) {
        Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]+|[-+*/^]");
        Matcher matcher = pattern.matcher(input);

        List<String> tokens = new ArrayList<>();
        while (matcher.find()) {
            tokens.add(matcher.group());
        }
        return tokens.toArray(new String[0]);
    }
}
