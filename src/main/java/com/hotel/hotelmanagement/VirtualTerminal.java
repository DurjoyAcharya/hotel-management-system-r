package com.hotel.hotelmanagement;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;

public class VirtualTerminal extends OutputStream {
    private final JTextArea textArea;
    private final StringBuilder sb = new StringBuilder();
    private String title;

    public VirtualTerminal(final JTextArea textArea, String title) {
        this.textArea = textArea;
        this.title = title;
        sb.append(title + "");
    }
    @Override
    public void close() {
    }

    @Override
    public void write(int b) throws IOException {

        if (b == '\r')
            return;

        if (b == '\n') {
            final String text = sb.toString() + "\n";
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    textArea.append(text);
                }
            });
            sb.setLength(0);
            sb.append(title + " ");
            return;
        }

        sb.append((char) b);
    }
}
