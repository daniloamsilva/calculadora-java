package com.daniloaugusto.calculadora;
import java.awt.Color;
import java.awt.Container; 
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * @author Danilo Augusto
 */
public class Calculadora extends JFrame implements ActionListener{
    
    // Visor da calculadora
    private final JLabel lblVisor;
    
    // Botões dos números
    private final JButton btn0;
    private final JButton btn1;
    private final JButton btn2;
    private final JButton btn3;
    private final JButton btn4;
    private final JButton btn5;
    private final JButton btn6;
    private final JButton btn7;
    private final JButton btn8;
    private final JButton btn9;
    
    // Botões dos operações
    private final JButton btnMais;
    private final JButton btnMenos;
    private final JButton btnDivide;
    private final JButton btnVezes;
    private final JButton btnIgual;
    
    // Outros botões
    private final JButton btnPonto;
    private final JButton btnSinal;
    private final JButton btnAC;
    
    private final Container container;
    private final Font fVisor;
    
    // Variáveis de controle
    private double numMemoria;              // Número guadado na memória
    private double numVisor;                // Número que está no visor
    private byte operacao;                  // Operação escolhida: 0n 1+ 2- 3* 4/
       
    // Variável de estado
    private byte estado;
    /*  Estado 0: estado inicial
        numMemoria = 0, numVisor = 0, operacao = 0
        primeiroNumero = true, numeroNegativo = false
    
        Estado 1: primeiro número foi digitado antes da operação
        numMemoria = 0, numVisor = (número digitado), operacao = 0
        primeiroNumero = false, numeroNegativo = true ou false
    
        Estado 2: operação selecionada
        numMemoria = (numero digitado antes), numVisor = (o mesmo), operacao = (operação escolhida)
        primeiroNumero = true, numeroNegativo = false
    
        Estado 3: primeiro número digitado depois da operação
        numMemoria = (número digitado antes), numVisor(número digitado agora)
        operacao = (operação escolhida), primeiroNumero = false, numeroNegativo = true ou false
    */
    

    
    public Calculadora(){
        this.estado = 0;
        
        // Configuração inicial
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(245,445);
        this.container = getContentPane();
        this.container.setLayout(null);
        
        // Configuração do painel
        this.lblVisor = new JLabel("0");
        this.lblVisor.setBounds(10,10,200,120);
        this.fVisor = new Font("SansSerif", Font.BOLD, 50);
        this.lblVisor.setFont(fVisor);
        this.lblVisor.setHorizontalAlignment(JLabel.RIGHT);
        this.lblVisor.setVerticalAlignment(JLabel.BOTTOM);
        
        // Configuração dos botões
        this.btnAC = new JButton("AC");
        this.btnSinal = new JButton("+/-");
        this.btnDivide = new JButton("/");
        this.btnAC.setBounds(10,135,105,52);
        this.btnSinal.setBounds(116,135,52,52);
        this.btnDivide.setBounds(169,135,52,52);
        // ========================================= //
        this.btn7 = new JButton("7");
        this.btn8 = new JButton("8");
        this.btn9 = new JButton("9");
        this.btnVezes = new JButton("*");
        this.btn7.setBounds(10,188,52,52);
        this.btn8.setBounds(63,188,52,52);
        this.btn9.setBounds(116,188,52,52);
        this.btnVezes.setBounds(169,188,52,52);
        // ========================================= //
        this.btn4 = new JButton("4");
        this.btn5 = new JButton("5");
        this.btn6 = new JButton("6");
        this.btnMenos = new JButton("-");
        this.btn4.setBounds(10,241,52,52);
        this.btn5.setBounds(63,241,52,52);
        this.btn6.setBounds(116,241,52,52);
        this.btnMenos.setBounds(169,241,52,52);
        // ========================================= //
        this.btn1 = new JButton("1");
        this.btn2 = new JButton("2");
        this.btn3 = new JButton("3");
        this.btn1.setBounds(10,294,52,52);
        this.btn2.setBounds(63,294,52,52);
        this.btn3.setBounds(116,294,52,52);
        // ========================================= //
        this.btnPonto = new JButton(".");
        this.btn0 = new JButton("0");
        this.btnIgual = new JButton("=");
        this.btnPonto.setBounds(10,347,52,52);
        this.btn0.setBounds(63,347,52,52);
        this.btnIgual.setBounds(116,347,52,52);
        // ========================================= //
        this.btnMais = new JButton("+");
        this.btnMais.setBounds(169,294,52,105);
        
        // Fonte botões
        Font fBotao = new Font("SansSerif", Font.PLAIN, 30);
        this.btn0.setFont(fBotao);
        this.btn1.setFont(fBotao);
        this.btn2.setFont(fBotao);
        this.btn3.setFont(fBotao);
        this.btn4.setFont(fBotao);
        this.btn5.setFont(fBotao);
        this.btn6.setFont(fBotao);
        this.btn7.setFont(fBotao);
        this.btn8.setFont(fBotao);
        this.btn9.setFont(fBotao);
        this.btnAC.setFont(fBotao);
        this.btnDivide.setFont(fBotao);
        this.btnVezes.setFont(fBotao);
        this.btnMenos.setFont(fBotao);
        this.btnMais.setFont(fBotao);
        this.btnIgual.setFont(fBotao);
        this.btnPonto.setFont(fBotao);
        
        Font fSinal = new Font("SansSerif", Font.PLAIN, 15);
        this.btnSinal.setFont(fSinal);
        
        // Adição dos componentes na tela
        container.add(this.lblVisor);
        
        container.add(this.btn0);
        container.add(this.btn1);
        container.add(this.btn2);
        container.add(this.btn3);
        container.add(this.btn4);
        container.add(this.btn5);
        container.add(this.btn6);
        container.add(this.btn7);
        container.add(this.btn8);
        container.add(this.btn9);
        container.add(this.btnAC);
        
        container.add(this.btnMais);
        container.add(this.btnMenos);
        container.add(this.btnVezes);
        container.add(this.btnDivide);
        
        container.add(this.btnSinal);
        container.add(this.btnPonto);
        container.add(this.btnIgual);

        // Listener dos botões
        this.btn1.addActionListener(this);
        this.btn2.addActionListener(this);
        this.btn3.addActionListener(this);
        this.btn4.addActionListener(this);
        this.btn5.addActionListener(this);
        this.btn6.addActionListener(this);
        this.btn7.addActionListener(this);
        this.btn8.addActionListener(this);
        this.btn9.addActionListener(this);
        this.btn0.addActionListener(this);
        
        this.btnMais.addActionListener(this);
        this.btnMenos.addActionListener(this);
        this.btnVezes.addActionListener(this);
        this.btnDivide.addActionListener(this);
        
        this.btnIgual.addActionListener(this);
        this.btnAC.addActionListener(this);
        this.btnSinal.addActionListener(this);
        this.btnPonto.addActionListener(this);
    }
    
    public static void main (String[] args){
        Calculadora tela = new Calculadora();
        tela.setResizable(false);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        switch (arg0.getActionCommand()) {
            case "0":                               // BUTTON 0
                String aux;
                switch (estado) {
                    case 1:
                        aux = this.lblVisor.getText();
                        aux = aux + "0";
                        if (this.pontoDigitado())
                            this.lblVisor.setText(String.valueOf(aux));
                        else {
                            this.numVisor = Double.valueOf(aux);
                            this.atualizarVisor();
                        }
                        break;
                    case 2:
                        this.numVisor = 0;
                        this.apagarOperacao();
                        this.atualizarVisor();
                        break;
                    case 3:
                        aux = this.lblVisor.getText();
                        aux = aux + "0";
                        if (this.pontoDigitado())
                            this.lblVisor.setText(String.valueOf(aux));
                        else {
                            this.numVisor = Double.valueOf(aux);
                            this.atualizarVisor();
                        }
                        break;
                }   
                break;
            case "1":                               // BUTTON 1
                this.numeros1a9(1);
                break;
            case "2":                               // BUTTON 2
                this.numeros1a9(2);
                break;
            case "3":                               // BUTTON 3
                this.numeros1a9(3);
                break;
            case "4":                               // BUTTON 4
                this.numeros1a9(4);
                break;
            case "5":                               // BUTTON 5
                this.numeros1a9(5);
                break;
            case "6":                               // BUTTON 6
                this.numeros1a9(6);
                break;
            case "7":                               // BUTTON 7
                this.numeros1a9(7);
                break;
            case "8":                               // BUTTON 8
                this.numeros1a9(8);
                break;
            case "9":                               // BUTTON 9
                this.numeros1a9(9);
                break;
            case "+":                               // BUTTON +
                this.operacaoSelecionada((byte) 1);
                break;
            case "-":                               // BUTTON -
                this.operacaoSelecionada((byte) 2);
                break;
            case "*":                               // BUTTON *
                this.operacaoSelecionada((byte) 3);
                break;
            case "/":                               // BUTTON /
                this.operacaoSelecionada((byte) 4);
                break;
            case "=":                               // BUTTON =
                switch (estado){
                    case 0:
                        if (this.numVisor != 0)
                            this.resultado();
                        break;
                    case 1:
                        this.estado = 0;
                        break;
                    case 2:
                        this.numMemoria = this.numVisor;
                        this.resultado();
                        this.apagarOperacao();
                        this.estado = 0;
                        break;
                    case 3:
                        double aux2 = this.numVisor;
                        this.resultado();
                        this.numMemoria = aux2;
                        this.estado = 0;
                        break;
                }
                break;
            case "+/-":                             // BUTTON +/-
                this.numVisor -= this.numVisor * 2;
                this.atualizarVisor();
                break;
            case ".":                               // BUTTON .
                if (estado == 0 || estado == 2){
                    this.numVisor = 0;
                    this.atualizarVisor();
                    this.apagarOperacao();
                    if (estado == 0)
                        this.estado = 1;
                    else // estado == 2
                        this.estado = 3;
                }
                
                if (!pontoDigitado())
                    this.lblVisor.setText(this.lblVisor.getText()+".");
                break;
            default:
                break;
        }
        
        if (arg0.getActionCommand().equals("AC") || arg0.getActionCommand().equals("C")){
            switch (estado) {
                    case 0:
                        this.btnAC.setText("AC");
                        this.numVisor = 0;
                        this.numMemoria = 0;
                        this.atualizarVisor();
                        break;
                    case 1:
                        this.btnAC.setText("AC");
                        this.numVisor = 0;
                        this.numMemoria = 0;
                        this.atualizarVisor();
                        this.estado = 0;
                        break;
                    case 2:
                        if (this.numVisor == 0){
                            this.btnAC.setText("AC");
                            this.apagarOperacao();
                            this.numMemoria = 0;
                            this.estado = 0;
                        } else {
                            this.btnAC.setText("AC");
                            this.numVisor = 0;
                            this.atualizarVisor();
                        }
                        break;
                    case 3:
                        this.btnAC.setText("AC");
                        this.numVisor = 0;
                        this.atualizarVisor();
                        this.acenderOperacao();
                        this.estado = 2;
                        break;
                }
        }
        this.debugging();
    }
    
    
    // Tratamento dos botões de 1 á 9
    public void numeros1a9(int numero){
        String aux;
        String numeroVisor = this.lblVisor.getText();
        char ultimoDigito = numeroVisor.charAt(numeroVisor.length()-1);
        String sud = String.valueOf(ultimoDigito);
        
        switch (estado) {
                case 0:
                    if (sud.equals(".")){
                        aux = this.lblVisor.getText();
                        aux = aux + String.valueOf(numero);
                        this.numVisor = Double.valueOf(aux);
                    } else{
                        this.numVisor = numero;
                        this.estado = 1;
                    }
                    this.atualizarVisor();
                    this.btnAC.setText("C");
                    break;
                case 1:
                    aux = this.lblVisor.getText();
                    aux = aux + String.valueOf(numero);
                    this.numVisor = Double.valueOf(aux);
                    this.atualizarVisor();
                    this.btnAC.setText("C");
                    break;
                case 2:
                    this.numVisor = numero;
                    this.estado = 3;
                    this.apagarOperacao();
                    this.atualizarVisor();
                    this.btnAC.setText("C");
                    break;
                case 3:
                    aux = this.lblVisor.getText();
                    aux = aux + String.valueOf(numero);
                    this.numVisor = Double.valueOf(aux);
                    this.atualizarVisor();
                    break;
            }
    }
    
    // Tratamento de botão de operação
    public void operacaoSelecionada(byte operacao){
        switch (estado) {
            case 0:
                this.operacao = operacao;
                this.acenderOperacao();
                this.numMemoria = this.numVisor;
                this.estado = 2;
                break;
            case 1:
                this.operacao = operacao;
                this.acenderOperacao();
                this.numMemoria = this.numVisor;
                this.estado = 2;
                break;
            case 2:
                this.apagarOperacao();
                this.operacao = operacao;
                this.acenderOperacao();
                break;
            case 3:
                this.resultado();
                this.operacao = operacao;
                this.acenderOperacao();
                this.numMemoria = this.numVisor;
                this.estado = 2;
                break;
        }
    }
    
    
    // Método resposável de atualizar o valor no visor
    public void atualizarVisor(){
        if (inteiro(this.numVisor))
            this.lblVisor.setText(String.valueOf((int) this.numVisor));
        else
            this.lblVisor.setText(String.valueOf(this.numVisor));
    }
    
    // Método para mudar a cor do botão de operação
    public void acenderOperacao(){
        switch (this.operacao){
            case 1:
                this.btnMais.setContentAreaFilled(false);
                this.btnMais.setOpaque(true);
                this.btnMais.setBackground(Color.LIGHT_GRAY);
                break;
            case 2:
                this.btnMenos.setContentAreaFilled(false);
                this.btnMenos.setOpaque(true);
                this.btnMenos.setBackground(Color.LIGHT_GRAY);
                break;
            case 3:
                this.btnVezes.setContentAreaFilled(false);
                this.btnVezes.setOpaque(true);
                this.btnVezes.setBackground(Color.LIGHT_GRAY);
                break;
            case 4:
                this.btnDivide.setContentAreaFilled(false);
                this.btnDivide.setOpaque(true);
                this.btnDivide.setBackground(Color.LIGHT_GRAY);
                break;
        }
    }
    
    // Retorna a cor original do botão de operação
    public void apagarOperacao() {
        switch (this.operacao) {
            case 1:
                this.btnMais.setContentAreaFilled(true);
                this.btnMais.setOpaque(false);
                this.btnMais.setBackground(null);  
                this.btnMais.setForeground(null);
                break;
            case 2:
                this.btnMenos.setContentAreaFilled(true);
                this.btnMenos.setOpaque(false);
                this.btnMenos.setBackground(null);  
                this.btnMenos.setForeground(null);
                break;
            case 3:
                this.btnVezes.setContentAreaFilled(true);
                this.btnVezes.setOpaque(false);
                this.btnVezes.setBackground(null);  
                this.btnVezes.setForeground(null);
                break;
            case 4:
                this.btnDivide.setContentAreaFilled(true);
                this.btnDivide.setOpaque(false);
                this.btnDivide.setBackground(null);  
                this.btnDivide.setForeground(null);
                break;
        }
    }
    
    // Método que verifica se um número é inteiro
    private boolean inteiro(double num) {
	int aux = (int)num;
	return (((double)aux) == num);
    }
    
    
    // Método responsável por fazer as contas
    public void resultado(){
        double resultado = 0;
        switch (this.operacao){
            case 1:
                resultado = this.numMemoria + this.numVisor;
                break;
            case 2:
                resultado = this.numMemoria - this.numVisor;
                break;
            case 3:
                resultado = this.numMemoria * this.numVisor;
                break;
            case 4:
                resultado = this.numMemoria / this.numVisor;
                break;
        }
        this.numVisor = resultado;
        this.atualizarVisor();
    }
    
    
    // Método de debugging
    public void debugging(){
        System.out.println("Estado: " + this.estado);
        System.out.println("Número visor: " + this.numVisor);
        System.out.println("Número memória: " + this.numMemoria);
        System.out.println("Operação: " + this.operacao);
        System.out.println("===================================");
    }

    // Método que verifica se o ponto foi digitado
    private boolean pontoDigitado() {
        int index = this.lblVisor.getText().indexOf(".");
        return index != -1;  
    }
    
}
