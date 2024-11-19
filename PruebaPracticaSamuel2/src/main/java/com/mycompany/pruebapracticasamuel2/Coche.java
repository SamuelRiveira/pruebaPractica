package com.mycompany.pruebapracticasamuel2;

import java.util.Random;

public class Coche implements Runnable {
    
    private final String matricula;
    private final Plaza plaza;
    
    private final Random random = new Random();

    public Coche(String matricula, Plaza plaza) {
        this.matricula = matricula;
        this.plaza = plaza;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public void run() {
        try {
            System.out.println("El coche con matrícula " + this.getMatricula() + " solicita aparcamiento");
            plaza.solicitarPlaza(this);
            Thread.sleep(10000 + random.nextInt(20000));
            plaza.abandonarPlaza(this);
        } catch (InterruptedException ex) {}
    }
}
