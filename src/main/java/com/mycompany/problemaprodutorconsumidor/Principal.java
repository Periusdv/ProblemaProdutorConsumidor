package com.mycompany.problemaprodutorconsumidor;

public class Principal {
    
     public static void main(String[] args) {
        Compartilhado recurso = new Compartilhado(); 
        
        Consumidor c1 = new Consumidor(recurso);
        Consumidor c2 = new Consumidor(recurso);
        
        c1.setTempo(750);
        c2.setTempo(1000);
       
        
        Produtor p1 = new Produtor(recurso);
        
        p1.setTempo(1000);
        
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(p1);
        Thread t3 = new Thread(c2);
        
        t1.start();
        t2.start();
        t3.start();
    }
}
