package estructuradatos;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

/**
 *
 * @author Carlo
 */
public class ShellSort extends javax.swing.JFrame {

    private ShellSortWorker shellSortWorker;

    public ShellSort() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNumeros = new javax.swing.JTextField();
        botonOrdenar = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        lbOrdenados = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPasos = new javax.swing.JTextArea();
        jToggleButton1 = new javax.swing.JToggleButton();
        txtNumAleatorio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Ordenamiento por método Shell");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Ingrese los numeros a acomodar separados por comas:");

        botonOrdenar.setText("Ordenar");
        botonOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOrdenarActionPerformed(evt);
            }
        });

        jLabel3.setText("Numeros Ordenados");

        lbOrdenados.setText("Numeros ordenados");

        jLabel4.setText("Pasos para ordenarlos:");

        txtPasos.setColumns(20);
        txtPasos.setRows(5);
        txtPasos.setFocusable(false);
        txtPasos.setOpaque(false);
        jScrollPane1.setViewportView(txtPasos);

        jToggleButton1.setText("Aleatorio");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        txtNumAleatorio.setText("Numeros Aleatorios");
        txtNumAleatorio.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(0, 84, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lbOrdenados)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(botonOrdenar)
                                .addComponent(txtNumeros, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumAleatorio)
                            .addComponent(jToggleButton1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNumeros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonOrdenar)
                    .addComponent(jToggleButton1))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNumAleatorio))
                .addGap(18, 18, 18)
                .addComponent(lbOrdenados)
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOrdenarActionPerformed
        ordenarNumeros();
    }//GEN-LAST:event_botonOrdenarActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        String input = JOptionPane.showInputDialog(this, "Ingrese la cantidad de numeros a aleatorios:");
        try {
            int cantidadNumeros = Integer.parseInt(input);
            if (cantidadNumeros > 0) {
                generarNumerosAleatorios(cantidadNumeros);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un número mayor a 0.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido.");
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void ordenarNumeros() {
        try {
            
            txtPasos.setText("");
            
            // Leer y procesar la entrada
            String inputText = txtNumeros.getText().trim();
            String aleatorioText = txtNumAleatorio.getText().trim();
            
            String[]inputArray;
            if(!inputText.isEmpty()){
                inputArray = inputText.split(",");
            }else if(!aleatorioText.isEmpty()){
                inputArray = aleatorioText.split(",");
            }else{
            JOptionPane.showMessageDialog(this,"Porfavor, ingrese o genere numeros antes de ordenar", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
            int[]numbers = Arrays.stream(inputArray)
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            shellSortWorker = new ShellSortWorker(numbers, txtPasos, lbOrdenados);
            shellSortWorker.execute();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese solo números separados por comas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void generarNumerosAleatorios(int cantidad) {
        StringBuilder numerosGenerados = new StringBuilder(); // Para mostrar los números en el JTextArea
        int[] numeros = new int[cantidad]; // Array para almacenar los números

        for (int i = 0; i < cantidad; i++) {
            numeros[i] = (int) (Math.random() * 100); // Genera un número aleatorio entre 0 y 99
            numerosGenerados.append(numeros[i]); // Agrega el número al StringBuilder

            if (i < cantidad - 1) {
                numerosGenerados.append(",");
            }

            // Muestra los números generados en el JTextArea (supongamos que se llama "txtAreaNumeros")
            txtNumAleatorio.setText(numerosGenerados.toString());
        }
    }

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
            java.util.logging.Logger.getLogger(ShellSort.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShellSort.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShellSort.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShellSort.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShellSort().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botonOrdenar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    public javax.swing.JLabel lbOrdenados;
    private javax.swing.JLabel txtNumAleatorio;
    private javax.swing.JTextField txtNumeros;
    private javax.swing.JTextArea txtPasos;
    // End of variables declaration//GEN-END:variables
}

class ShellSortWorker extends SwingWorker<Void, String> {

    private final int[] numbers;
    private final JTextArea txtPasos;
    private javax.swing.JLabel lbOrdenados;

    public ShellSortWorker(int[] numbers, JTextArea txtPasos, JLabel lbOrdenados) {
        this.numbers = numbers;
        this.txtPasos = txtPasos;
        this.lbOrdenados = lbOrdenados;
    }

    @Override
    protected Void doInBackground() throws Exception {
        int n = numbers.length;
        int gap = n / 2;

         publish("Estado inicial: " + Arrays.toString(numbers));
        
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int temp = numbers[i];
                int j = i;
                
                while (j >= gap && numbers[j - gap] > temp) {
                    publish("Comparando " + numbers[j - gap] + " y " + temp);
                    numbers[j] = numbers[j - gap];
                    j -= gap;
                }
                numbers[j] = temp;
                
                publish("Colocando " + temp + " en la posición " + j);
                publish("Array después del intercambio: " + Arrays.toString(numbers));
            }
            gap /= 2;
        }
        return null;
    }

    @Override
    protected void process(java.util.List<String> chunks) {
        for (String step : chunks) {
            txtPasos.append(step + "\n");
        }
    }

    @Override
    protected void done() {
        try{
         SwingUtilities.invokeLater(() -> lbOrdenados.setText("Números ordenados: " + Arrays.toString(numbers)));
        JOptionPane.showMessageDialog(null, "Ordenamiento Completo!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
