package expresion;

import static expresion.ConversorInfijaAPosfija.convertirInfijaAPosfija;
import static expresion.ConvertirInfijaAPostfija.convertirPrefijaAPostfija;
import static expresion.ConvertirInfijaAPrefija.convertirInfijaAPrefija;
import static expresion.ConvertirPostfijaAInfija.convertirPostfijaAInfija;
import static expresion.ConvertirPostfijaAPrefija.convertirPostfijaAPrefija;
import static expresion.ConvertirPrefijaAInfija.convertirPrefijaAInfija;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class Expresiones extends javax.swing.JFrame {
    
    
    
    public Expresiones() {
        initComponents();
        this.in = new Infix(lblTipoExp);
        this.po = new Postfix(lblTipoExp);
        this.pre = new Prefix(lblTipoExp);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtExpresion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblTipoExp = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnInfAPos = new javax.swing.JButton();
        btnInfAPref = new javax.swing.JButton();
        btnPosAPref = new javax.swing.JButton();
        btnPrefAPos = new javax.swing.JButton();
        btnPosAInf = new javax.swing.JButton();
        btnPrefAInf = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtConversion = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Bienvenido,");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Ingrese la expresión:");

        jButton1.setText("Validar Expresión");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("El tipo de expresion es :");

        lblTipoExp.setText("NULL");
        lblTipoExp.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Seleccione la conversión a realizar:");
        jLabel4.setEnabled(false);

        btnInfAPos.setText("Infija a PosFija");
        btnInfAPos.setEnabled(false);
        btnInfAPos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfAPosActionPerformed(evt);
            }
        });

        btnInfAPref.setText("Infija a Prefija");
        btnInfAPref.setEnabled(false);
        btnInfAPref.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfAPrefActionPerformed(evt);
            }
        });

        btnPosAPref.setText("PosFija a Prefija");
        btnPosAPref.setEnabled(false);
        btnPosAPref.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPosAPrefActionPerformed(evt);
            }
        });

        btnPrefAPos.setText("Prefija A PosFija");
        btnPrefAPos.setEnabled(false);
        btnPrefAPos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrefAPosActionPerformed(evt);
            }
        });

        btnPosAInf.setText("PosFija a Infija");
        btnPosAInf.setEnabled(false);
        btnPosAInf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPosAInfActionPerformed(evt);
            }
        });

        btnPrefAInf.setText("Prefija a Infija");
        btnPrefAInf.setEnabled(false);
        btnPrefAInf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrefAInfActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Expresión Convertida");
        jLabel5.setEnabled(false);

        txtConversion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConversionActionPerformed(evt);
            }
        });

        jButton2.setText("Evaluar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTipoExp))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtExpresion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20)
                                    .addComponent(jButton1))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnInfAPos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnInfAPref, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(100, 100, 100)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnPosAPref, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPosAInf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(100, 100, 100)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnPrefAPos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPrefAInf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(277, 277, 277)
                                .addComponent(jLabel5)))
                        .addGap(0, 74, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtConversion, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExpresion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblTipoExp))
                .addGap(54, 54, 54)
                .addComponent(jLabel4)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInfAPos)
                    .addComponent(btnPosAPref)
                    .addComponent(btnPrefAPos))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInfAPref)
                    .addComponent(btnPosAInf)
                    .addComponent(btnPrefAInf))
                .addGap(42, 42, 42)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConversion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    Infix in;
    Postfix po;
    Prefix pre;
    
    private void btnInfAPrefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfAPrefActionPerformed
        String exp = txtExpresion.getText().trim();
        String expresionPrefija = convertirInfijaAPrefija(exp);
        txtConversion.setEnabled(true);
        txtConversion.setText(expresionPrefija);
    }//GEN-LAST:event_btnInfAPrefActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String exp = txtExpresion.getText().trim();
        deshabilitarBotonesConversion();
        
        if ( esExpresionIncompleta(exp)){
             lblTipoExp.setText("Error: La expresión está incompleta.");
        JOptionPane.showMessageDialog(null,
                "La expresión ingresada contiene solo un carácter (letra o número). Ingrese una expresión válida.",
                "Error de Validación",
                JOptionPane.ERROR_MESSAGE);
        return;
        }
        if (po.esPosfijaValida(exp) != false) {
            lblTipoExp.setEnabled(true);
            lblTipoExp.setText("Posfija");
            
            int respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Desea evaluar la expresión?",
                    "Confirmar Acción",
                    JOptionPane.YES_NO_OPTION
            );
            
            if (respuesta == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null,
                        "El valor de la evaluacion es de: " + Postfix.postfixEvaluate(exp),
                        "Evaluación de expresión",
                        JOptionPane.INFORMATION_MESSAGE,
                        null);
            }
            habilitarBotonesTipo("Posfija");
        } else if (in.esInfijaValida(exp)) {
            lblTipoExp.setEnabled(true);
            lblTipoExp.setText("Infija");
            habilitarBotonesTipo("Infija");
            
            int respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Desea evaluar la expresión?",
                    "Confirmar Acción",
                    JOptionPane.YES_NO_OPTION
            );
            
            if (respuesta == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null,
                        "El valor de la evaluacion es de: " + Infix.evaluate(exp),
                        "Evaluación de expresión",
                        JOptionPane.INFORMATION_MESSAGE,
                        null);
            }
            
        } else if (pre.esPrefijaValida(exp) != false) {
            lblTipoExp.setEnabled(true);
            lblTipoExp.setText("Prefija");
            habilitarBotonesTipo("Prefija");
            
            int respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Desea evaluar la expresión?",
                    "Confirmar Acción",
                    JOptionPane.YES_NO_OPTION
            );
            
            if (respuesta == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null,
                        "El valor de la evaluacion es de: " + Prefix.evaluatePrefix(exp),
                        "Evaluación de expresión",
                        JOptionPane.INFORMATION_MESSAGE,
                        null);
            }
            
        } else {
            deshabilitarBotonesConversion();
        }
        
        txtConversion.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnInfAPosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfAPosActionPerformed
        String exp = txtExpresion.getText().trim();
        String expresionPosfija = convertirInfijaAPosfija(exp);
        txtConversion.setEnabled(true);
        txtConversion.setText(expresionPosfija);
    }//GEN-LAST:event_btnInfAPosActionPerformed

    private void txtConversionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConversionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConversionActionPerformed

    private void btnPosAPrefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPosAPrefActionPerformed
        String exp = txtExpresion.getText().trim();
        String expPostfija = convertirPostfijaAPrefija(exp);
        txtConversion.setEnabled(true);
        txtConversion.setText(expPostfija);
    }//GEN-LAST:event_btnPosAPrefActionPerformed

    private void btnPosAInfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPosAInfActionPerformed
        String exp = txtExpresion.getText().trim();
        String expPostfija = convertirPostfijaAInfija(exp);
        txtConversion.setEnabled(true);
        txtConversion.setText(expPostfija);
    }//GEN-LAST:event_btnPosAInfActionPerformed

    private void btnPrefAPosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrefAPosActionPerformed
        String exp = txtExpresion.getText().trim();
        String expPrefija = convertirPrefijaAPostfija(exp);
        txtConversion.setEnabled(true);
        txtConversion.setText(expPrefija);
    }//GEN-LAST:event_btnPrefAPosActionPerformed

    private void btnPrefAInfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrefAInfActionPerformed
        String exp = txtExpresion.getText().trim();
        String expPrefija = convertirPrefijaAInfija(exp);
        txtConversion.setEnabled(true);
        txtConversion.setText(expPrefija);
    }//GEN-LAST:event_btnPrefAInfActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(lblTipoExp.getText() == "Infija"){
            String exp = txtExpresion.getText().trim();
            //Infix.evaluate(exp);
            JOptionPane.showMessageDialog(null,
                        "El valor de la evaluacion es de: " + Infix.evaluate(exp),
                        "Evaluación de expresión",
                        JOptionPane.INFORMATION_MESSAGE,
                        null);
        }else if(lblTipoExp.getText() == "Posfija"){
            String exp = txtExpresion.getText().trim();
            //Postfix.postfixEvaluate(exp);
             JOptionPane.showMessageDialog(null,
                        "El valor de la evaluacion es de: " + Postfix.postfixEvaluate(exp),
                        "Evaluación de expresión",
                        JOptionPane.INFORMATION_MESSAGE,
                        null);
        }else if(lblTipoExp.getText() == "Prefija"){
            String exp = txtExpresion.getText().trim();
            //Prefix.evaluatePrefix(exp);
            JOptionPane.showMessageDialog(null,
                        "El valor de la evaluacion es de: " + Prefix.evaluatePrefix(exp),
                        "Evaluación de expresión",
                        JOptionPane.INFORMATION_MESSAGE,
                        null);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Expresiones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Expresiones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Expresiones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Expresiones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Expresiones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInfAPos;
    private javax.swing.JButton btnInfAPref;
    private javax.swing.JButton btnPosAInf;
    private javax.swing.JButton btnPosAPref;
    private javax.swing.JButton btnPrefAInf;
    private javax.swing.JButton btnPrefAPos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblTipoExp;
    private javax.swing.JTextField txtConversion;
    private javax.swing.JTextField txtExpresion;
    // End of variables declaration//GEN-END:variables

    private void habilitarBotonesTipo(String tipo) {
        deshabilitarBotonesConversion();
        switch (tipo) {
            case "Infija":
                btnInfAPref.setEnabled(true);
                btnInfAPos.setEnabled(true);
                break;
            case "Posfija":
                btnPosAPref.setEnabled(true);
                btnPosAInf.setEnabled(true);
                break;
            case "Prefija":
                btnPrefAPos.setEnabled(true);
                btnPrefAInf.setEnabled(true);
                break;
        }
    }
    
    private void deshabilitarBotonesConversion() {
        btnInfAPos.setEnabled(false);
        btnInfAPref.setEnabled(false);
        btnPosAPref.setEnabled(false);
        btnPrefAPos.setEnabled(false);
        btnPosAInf.setEnabled(false);
        btnPrefAInf.setEnabled(false);
    }

    
    private boolean esExpresionIncompleta(String exp) {
    // Eliminar espacios para validar caracteres reales
    String cleanedExp = exp.replaceAll("\\s+", "");
    
    // Validar si contiene solo un carácter
    if (cleanedExp.length() == 1) {
        char ch = cleanedExp.charAt(0);
        // Verificar si es una letra o un número
        if (Character.isLetterOrDigit(ch)) {
            return true; // Es incompleta
        }
    }
    return false; // Es válida
}    

}

class ConversorInfijaAPosfija {

    // Método para convertir una expresión infija a posfija
    public static String convertirInfijaAPosfija(String exp) {
        Stack<Character> pila = new Stack<>();
        StringBuilder resultado = new StringBuilder();

        // Recorrer cada carácter de la expresión
        for (int i = 0; i < exp.length(); i++) {
            char token = exp.charAt(i);

            // Si el token es un número o una variable, agregarlo al resultado
            if (Character.isLetterOrDigit(token)) {
                resultado.append(token);
            } // Si el token es un paréntesis de apertura, agregarlo a la pila
            else if (token == '(') {
                pila.push(token);
            } // Si el token es un paréntesis de cierre
            else if (token == ')') {
                // Extraer de la pila hasta encontrar un paréntesis de apertura
                while (!pila.isEmpty() && pila.peek() != '(') {
                    resultado.append(pila.pop());
                }
                pila.pop(); // Descartar el paréntesis de apertura
            } // Si el token es un operador
            else if (esOperador(token)) {
                // Extraer operadores de la pila con mayor o igual prioridad
                while (!pila.isEmpty() && prioridad(pila.peek()) >= prioridad(token)) {
                    resultado.append(pila.pop());
                }
                // Colocar el operador en la pila
                pila.push(token);
            }
        }

        // Vaciar la pila y agregar los operadores restantes al resultado
        while (!pila.isEmpty()) {
            resultado.append(pila.pop());
        }
        
        return resultado.toString();
    }

    // Método para verificar si el token es un operador
    public static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' ;
    }

    // Método para obtener la prioridad de los operadores
    public static int prioridad(char c) {
    if (c == '+' || c == '-') {
        return 1; // Menor prioridad
    } else if (c == '*' || c == '/') {
        return 2; // Prioridad intermedia
    } else if (c == '^') {
        return 3; // Mayor prioridad
    } else {
        return -1; // No es un operador
    }
}

}

class ConvertirInfijaAPrefija {

    // Método para convertir una expresión infija a prefija
    public static String convertirInfijaAPrefija(String exp) {
        // Paso 1: Invertir la expresión
        String expInvertida = invertirExpresion(exp);

        // Paso 2: Sustituir los paréntesis
        expInvertida = sustituirParentesis(expInvertida);

        // Paso 3: Convertir la expresión invertida a posfija
        String posfija = convertirInfijaAPosfija(expInvertida);

        // Paso 4: Invertir la expresión posfija para obtener la prefija
        return new StringBuilder(posfija).reverse().toString();
    }

    // Método para invertir la expresión
    public static String invertirExpresion(String exp) {
        StringBuilder sb = new StringBuilder(exp);
        return sb.reverse().toString();
    }

    // Método para sustituir los paréntesis
    public static String sustituirParentesis(String exp) {
        return exp.replace('(', '↑').replace(')', '(').replace('↑', ')');
    }

    // Método para convertir infija a posfija (como en el ejemplo anterior)
    public static String convertirInfijaAPosfija(String exp) {
        Stack<Character> pila = new Stack<>();
        StringBuilder resultado = new StringBuilder();
        
        for (int i = 0; i < exp.length(); i++) {
            char token = exp.charAt(i);
            
            if (Character.isLetterOrDigit(token)) {
                resultado.append(token);
            } else if (token == '(') {
                pila.push(token);
            } else if (token == ')') {
                while (!pila.isEmpty() && pila.peek() != '(') {
                    resultado.append(pila.pop());
                }
                pila.pop();
            } else if (esOperador(token)) {
                while (!pila.isEmpty() && prioridad(pila.peek()) >= prioridad(token)) {
                    resultado.append(pila.pop());
                }
                pila.push(token);
            }
        }
        
        while (!pila.isEmpty()) {
            resultado.append(pila.pop());
        }
        
        return resultado.toString();
    }

    // Método para verificar si el token es un operador
    public static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    public static int prioridad(char c) {
    if (c == '+' || c == '-') {
        return 1; // Menor prioridad
    } else if (c == '*' || c == '/') {
        return 2; // Prioridad intermedia
    } else if (c == '^') {
        return 3; // Mayor prioridad
    } else {
        return -1; // No es un operador
    }
}

}

class ConvertirPostfijaAPrefija {
    
    public static String convertirPostfijaAPrefija(String exp) {
        Stack<String> pila = new Stack<>();

        // Recorrer la expresión postfija
        for (int i = 0; i < exp.length(); i++) {
            char token = exp.charAt(i);
            
            if (Character.isLetterOrDigit(token)) {
                // Si es un operando, lo apilamos
                pila.push(String.valueOf(token));
            } else if (esOperador(token)) {
                // Si es un operador, sacamos los dos operandos de la pila
                String operando2 = pila.pop();
                String operando1 = pila.pop();

                // Formamos la expresión prefija
                String prefija = token + operando1 + operando2;

                // La apilamos de nuevo
                pila.push(prefija);
            }
        }

        // Al final, la pila debe contener la expresión prefija
        return pila.pop();
    }

    // Método para verificar si un carácter es un operador
    public static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }
}

class ConvertirPostfijaAInfija {
    
    public static String convertirPostfijaAInfija(String exp) {
        Stack<String> pila = new Stack<>();

        // Recorrer la expresión postfija
        for (int i = 0; i < exp.length(); i++) {
            char token = exp.charAt(i);
            
            if (Character.isLetterOrDigit(token)) {
                // Si es un operando, lo apilamos
                pila.push(String.valueOf(token));
            } else if (esOperador(token)) {
                // Si es un operador, sacamos dos operandos de la pila
                String operando2 = pila.pop();
                String operando1 = pila.pop();

                // Formamos la expresión infija con paréntesis
                String infija = "(" + operando1 + token + operando2 + ")";

                // La apilamos de nuevo
                pila.push(infija);
            }
        }

        // Al final, la pila debe contener la expresión infija
        return pila.pop();
    }

    // Método para verificar si un carácter es un operador
    public static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }
    
}

class ConvertirInfijaAPostfija {

    // Método para convertir una expresión prefija a postfija
    public static String convertirPrefijaAPostfija(String exp) {
        Stack<String> pila = new Stack<>();

        // Recorrer la expresión prefija de derecha a izquierda
        for (int i = exp.length() - 1; i >= 0; i--) {
            char token = exp.charAt(i);
            
            if (Character.isLetterOrDigit(token)) {
                // Si es un operando, lo empujamos a la pila
                pila.push(String.valueOf(token));
            } else if (esOperador(token)) {
                // Si es un operador, sacamos dos operandos de la pila
                String operando1 = pila.pop();
                String operando2 = pila.pop();

                // Formamos la expresión postfija
                String postfija = operando1 + operando2 + token;

                // Empujamos la expresión postfija resultante de vuelta a la pila
                pila.push(postfija);
            }
        }

        // Al final, la pila debe contener la expresión postfija
        return pila.pop();
    }

    // Método para verificar si un carácter es un operador
    public static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }
    
}

class ConvertirPrefijaAInfija {

    // Método para convertir una expresión prefija a infija
    public static String convertirPrefijaAInfija(String exp) {
        Stack<String> pila = new Stack<>();

        // Recorrer la expresión prefija de derecha a izquierda
        for (int i = exp.length() - 1; i >= 0; i--) {
            char token = exp.charAt(i);
            
            if (Character.isLetterOrDigit(token)) {
                // Si es un operando, lo empujamos a la pila
                pila.push(String.valueOf(token));
            } else if (esOperador(token)) {
                // Si es un operador, sacamos dos operandos de la pila
                String operando1 = pila.pop();
                String operando2 = pila.pop();

                // Formamos la expresión infija con paréntesis
                String infija = "(" + operando1 + token + operando2 + ")";

                // Empujamos la expresión infija resultante de vuelta a la pila
                pila.push(infija);
            }
        }

        // Al final, la pila debe contener la expresión infija
        return pila.pop();
    }

    // Método para verificar si un carácter es un operador
    public static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }
}

class EvaluadorPosfijo {
    
    public static double evaluarPosfija(String posfija) {
        Deque<Double> pila = new ArrayDeque<>();  // Usando ArrayDeque en lugar de Stack
        String[] tokens = posfija.trim().split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");
        
        System.out.println("Tokens: ");
        for (String token : tokens) {
            
            token = token.trim();
            
            System.out.println(token);  // Imprimir los tokens para ver lo que estamos procesando

            // Si es un número, lo apilamos
            if (esNumero(token)) {
                pila.push(Double.parseDouble(token)); // Convertimos el token a un número
            } // Si es un operador, realizamos la operación
            else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^")) {
                if (pila.size() < 2) {
                    throw new IllegalArgumentException("Error: expresión inválida, insuficientes operandos");
                }
                double b = pila.pop();
                double a = pila.pop();
                double resultado = 0;
                
                switch (token) {
                    case "+":
                        resultado = a + b;
                        break;
                    case "-":
                        resultado = a - b;
                        break;
                    case "*":
                        resultado = a * b;
                        break;
                    case "/":
                        if (b != 0) {
                            resultado = a / b;
                        } else {
                            throw new ArithmeticException("Error: División por cero");
                        }
                        break;
                    case "^":
                        resultado = Math.pow(a, b);  // Exponente
                        break;
                }
                pila.push(resultado); // Apilamos el resultado de la operación
            } else {
                throw new IllegalArgumentException("Error: token no válido: " + token);
            }
        }
        
        System.out.println("Contenido de la pila después de procesar los tokens: " + pila);

        // Verificamos si hay un solo resultado final
        if (pila.size() != 1) {
            throw new IllegalArgumentException("Error: expresión inválida, número de operandos y operadores no coincide");
        }

        // El resultado final está en la cima de la pila
        return pila.pop();
    }
// Método para verificar si el token es un número (para más de un dígito)

    private static boolean esNumero(String token) {
        try {
            Double.parseDouble(token); // Intentar convertir a número
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
}

