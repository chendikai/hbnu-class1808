package cn.hbnu.edu.stream;

import java.io.IOException;
import java.io.PipedOutputStream;

public class PipedOutputStreamDemo implements Runnable {

    private PipedOutputStream pipedOutputStream = null;

    public PipedOutputStreamDemo() {
        this.pipedOutputStream = new PipedOutputStream();
    }

    public PipedOutputStream getPipedOutputStream() {
        return pipedOutputStream;
    }

    @Override
    public void run() {
        String str = "湖北师范大学，计信1808班";
        byte[] bytes = str.getBytes();
        try {
            pipedOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                pipedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
