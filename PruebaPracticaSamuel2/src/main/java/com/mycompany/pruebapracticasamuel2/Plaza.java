package com.mycompany.pruebapracticasamuel2;

import java.util.Random;

public class Plaza {
    
    private boolean disponiblePlaza0 = true;
    private boolean disponiblePlaza1 = true;
    private boolean disponiblePlaza2 = true;
    private boolean disponiblePlaza3 = true;
    private boolean disponiblePlaza4 = true;
    private int plazasDisponibles = 5;
    private int plazaAOcupar;
    
    public synchronized void solicitarPlaza(Coche coche) throws InterruptedException {
        
        //Esperar a que hayan plazas disponibles
        while ((!disponiblePlaza0)
                || (!disponiblePlaza1)
                || (!disponiblePlaza2)
                || (!disponiblePlaza3)
                || (!disponiblePlaza4)){
            System.out.println("--El coche con matrícula " + coche.getMatricula());
            wait();
        }
        
        // Ocupar plaza
        if(disponiblePlaza0){
            disponiblePlaza0 = false;
            plazasDisponibles -= 1;
            plazaAOcupar = 0;
        } else if(disponiblePlaza1){
            disponiblePlaza1 = false;
            plazasDisponibles -= 1;
            plazaAOcupar = 1;
        } else if(disponiblePlaza2){
            disponiblePlaza2 = false;
            plazasDisponibles -= 1;
            plazaAOcupar = 2;
        } else if(disponiblePlaza3){
            disponiblePlaza3 = false;
            plazasDisponibles -= 1;
            plazaAOcupar = 3;
        } else if(disponiblePlaza4){
            disponiblePlaza4 = false;
            plazasDisponibles -= 1;
            plazaAOcupar = 4;
        }
        System.out.println("El coche con matrícula " + coche.getMatricula() + " entra al aparcamiento, ocupa la plaza " + plazaAOcupar + ", plazas disponibles: " + plazasDisponibles);
    }
    
    public synchronized void abandonarPlaza(Coche coche) throws InterruptedException{
        
        //Abandonar plaza
        if(plazaAOcupar == 0 && !disponiblePlaza0){
            disponiblePlaza0 = true;
            plazasDisponibles += 1;
        } else if(plazaAOcupar == 1 && !disponiblePlaza1){
            disponiblePlaza1 = true;
            plazasDisponibles += 1;
        } else if(plazaAOcupar == 2 && !disponiblePlaza2){
            disponiblePlaza2 = true;
            plazasDisponibles += 1;
        } else if(plazaAOcupar == 3 && !disponiblePlaza3){
            disponiblePlaza3 = true;
            plazasDisponibles += 1;
        } else if(plazaAOcupar == 4 && !disponiblePlaza4){
            disponiblePlaza4 = true;
            plazasDisponibles += 1;
        }
        
        System.out.println("El coche con matrícula " + coche.getMatricula() + " sale del aparcamiento, deja libre la plaza " + plazaAOcupar + ", plazas disponibles: " + plazasDisponibles);
        notifyAll();
    }
}
