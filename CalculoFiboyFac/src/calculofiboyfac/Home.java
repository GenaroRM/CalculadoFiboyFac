/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculofiboyfac;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Sanchez Mendez Edmundo y Rodriguez Morua Genaro
 * @version 1.0 20/08/17
 */
public class Home extends JFrame implements ActionListener{
    JButton cerrar;
    JTextField Numero;
    JButton Fibonacci;
    JButton Factorial;
    JLabel resultado;
    JTextField resultado1;
    double nsaldo=0;
    int Fact,fibo;
    Boolean Continuar=false;
    private JLabel titulo, instruccion;
    
    public Home(){
        configurarVentana();
       iniciarComponentes();
    }
    //Configuramos el tamaño y otras caracteristicas de la ventana
    public void configurarVentana(){
        setTitle("Convertido de numero entero a Fibonacci & Factorial");
        setSize(600,510);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setBackground(new Color(220,216,255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //Inicialiciamos los componentes que la ventana tendra
    public void iniciarComponentes(){
        titulo = new JLabel("Convertidor de numero entero a Fibonacci & Factorial");
        titulo.setBounds(30, 25, 750, 30);
        titulo.setFont(new Font ("Arial",Font.BOLD,20));
        add(titulo);
        titulo.setVisible(true);
        
        instruccion =  new JLabel("Numero:");
        instruccion.setBounds(10, 80, 300, 30);
        instruccion.setFont(new Font("Arial",0,16));
        add(instruccion);
        instruccion.setVisible(true);
        
        Numero= new JTextField();
        Numero.setBounds(200, 80, 300, 35);
	Numero.setFont(new Font("Arial", Font.BOLD, 25));
        Numero.setHorizontalAlignment(JTextField.CENTER);
	Numero.setEditable(true);
        add(Numero);
        Numero.setVisible(true);
        
        Fibonacci = new JButton("Fibonacci");
        Fibonacci.setBounds(350, 140, 100, 50);
        add(Fibonacci);
        Fibonacci.addActionListener(this);
        add(Fibonacci);
      
        Factorial = new JButton("Factorial");
        Factorial.setBounds(350, 200, 100, 50);
        add(Factorial);
        Factorial.addActionListener(this);
        add(Factorial);     
        
        resultado =  new JLabel("Resultado:");
        resultado.setBounds(10, 300, 300, 30);
        resultado.setFont(new Font("Arial",0,16));
        add(resultado);
        resultado.setVisible(true);
        
        resultado1= new JTextField();
        resultado1.setBounds(100, 300, 475, 35);
	resultado1.setFont(new Font("Arial", Font.BOLD, 25));
        resultado1.setHorizontalAlignment(JTextField.CENTER);
	resultado1.setEditable(false);
        add(resultado1);
        resultado1.setVisible(true);
    }
    //Damos instrucciones a los botones
    @Override
    public void actionPerformed(ActionEvent e){
       //valida los campos
        if(e.getSource()==Fibonacci){
           String nada =Numero.getText();
        if(nada.length()>=5){
           JOptionPane.showMessageDialog(this, "Capacidad Maxima para poder hacer la operacion");
           resultado1.setText("No hay numero");
        }else if(nada.matches(".*[^0123456789].*") ){
          JOptionPane.showMessageDialog(this, "No ingreso numeros");
          resultado1.setText("No hay numero");
        }else if(nada.isEmpty()){
          JOptionPane.showMessageDialog(this, "No ingreso nada");
          resultado1.setText("No ingreso numero");
        }else{
           fibo=Integer.parseInt(Numero.getText());
                   String s="0";
        if (fibo>0){ 
        int a=0; 
        int b=1;    
        int c; 
        for(int i=1; i<fibo;i++){ 
            c=a+b; 
            a=b; 
            b=c;     
            s = s + ", " + a;     
        }  
                resultado1.setText(s);
        }else{
            resultado1.setText("0 no tiene num de fibonacci ");
        }
        }
       }else if(e.getSource()==Factorial){
         String nada =Numero.getText();
        if(nada.length()>=5){
           JOptionPane.showMessageDialog(this, "Capacidad Maxima para poder hacer la operacion");
           resultado1.setText("No hay numero");
        }else if(nada.matches(".*[^0123456789].*") ){
          JOptionPane.showMessageDialog(this, "No ingreso numeros");
          resultado1.setText("No hay numero");
        
        }else if(nada.isEmpty()){
            JOptionPane.showMessageDialog(this, "No ingreso nada");
            resultado1.setText("No ingreso nada");
        }else{
           fibo=Integer.parseInt(Numero.getText());
           double factorial=1;
           double numero = fibo;
           if(fibo==0){
            JOptionPane.showMessageDialog(this, "No hay factorial de 0");
            resultado1.setText("No existe");
           }else{
            while(numero!=0){
            factorial=factorial*numero;
            numero--;
            String mostrar = Double.toString(factorial);
            if (mostrar.equalsIgnoreCase("infinity")){               
                resultado1.setText("Es un numero muy grande");
            }else{
                resultado1.setText(mostrar);

            }
           }  
           }
        }
        
       }
    }
   
}

