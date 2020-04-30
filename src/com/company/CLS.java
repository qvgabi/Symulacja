package com.company;;

import java.io.IOException;

public class CLS {
    public void cls(String... arg) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
