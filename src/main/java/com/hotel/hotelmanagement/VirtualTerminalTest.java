package com.hotel.hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;

@SuppressWarnings("serial")
public class VirtualTerminalTest extends JPanel {
    private final JTextArea textArea = new JTextArea(30, 60);
    private final VirtualTerminal taOutputStream = new VirtualTerminal(textArea, "");

    public VirtualTerminalTest(String bill_id, String name, String id, String phone, String check_in
    , String check_out) {
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

        System.setOut(new PrintStream(taOutputStream));

        textArea.setFont(new Font(Font.MONOSPACED,Font.BOLD,24));
        textArea.setBackground(new Color(135,206,235));
        textArea.setSize(new Dimension(600,600));
        System.out.println("\t\t\tBill Details");
        System.out.println("\t---------------------------------------");
        System.out.println("\t\t  Bill Id: "+bill_id);
        System.out.println("\t\t  Name: "+name);
        System.out.println("\t\t  Phone: "+phone);
        System.out.println("\t\t  ID Number: "+bill_id);
        System.out.println("\t\t  Check In: "+check_in);
        System.out.println("\t\t  Check Out: "+check_out);
    }

    public void createAndShowGui(String bill_id, String name, String id, String phone, String check_in
            ,String check_out) {
        JFrame frame = new JFrame("Bill Details");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.getContentPane().add(new VirtualTerminalTest(bill_id, name, id, phone, check_in, check_out));
        frame.setSize(800,800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
