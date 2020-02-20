/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Norath
 */
public class HiloRecepcion extends Thread {

    private Socket conexion;
    private JTextArea txtChat;

    public HiloRecepcion(Socket conexion, JTextArea txtChat) {
        this.conexion = conexion;
        this.txtChat = txtChat;
    }

    public void run() {

        do {

            Scanner entrada = null;
            try {
                entrada = new Scanner(conexion.getInputStream());
                String mensaje = entrada.nextLine();                
                txtChat.append(mensaje+"\r\n");
                
            } catch (IOException ex) {
                Logger.getLogger(HiloRecepcion.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (conexion.isConnected());

    }

}
