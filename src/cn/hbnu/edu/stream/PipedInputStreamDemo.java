package cn.hbnu.edu.stream;

import java.io.IOException;
import java.io.PipedInputStream;

public class PipedInputStreamDemo implements Runnable {

    private PipedInputStream pipedInputStream = null;

    public PipedInputStreamDemo() {
        this.pipedInputStream = new PipedInputStream();
    }

    public PipedInputStream getPipedInputStream() {
        return pipedInputStream;
    }

    @Override
    public void run() {
        byte[] bytes = new byte[1024];
        int length = 0;
        try {
            length = pipedInputStream.read(bytes);

            System.out.println(new String(bytes, 0, length));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                pipedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
