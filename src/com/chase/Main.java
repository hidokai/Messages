package com.chase;

import java.io.FileNotFoundException;

class Main {
    public static void main(String[] args) throws FileNotFoundException {
        App app = new App("input.txt");
        app.Run();
    }
}