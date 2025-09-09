package com.mycompany.problemaprodutorconsumidor;

public class Compartilhado {

    private int buffer;
    private int tamanhoBuffer;

    public Compartilhado() {
        this(0, 5);
    }

    public Compartilhado(int buffer, int tamanhoBuffer) {
        setBuffer(buffer);
        setTamanhoBuffer(tamanhoBuffer);
    } 

    public synchronized void consumir() {
        while (getBuffer() <= getTamanhoBuffer()) {
            System.out.println("Buffer Cheio, Consumidor esperando pelo Produtor");
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        setBuffer(getBuffer() - 1);
        System.out.println("Consumidor consumindo / buffer :" + getBuffer());
        notify();
    }

    public synchronized void produzir() {
        while (getBuffer() >= getTamanhoBuffer()) {
            System.out.println("Buffer Cheio, Produtor esperando pelo Consumidor");
            try {
                wait();
            } catch (InterruptedException e){}
        }
        setBuffer(getBuffer() + 1);
        System.out.println("Produtor produzindo / buffer :" + getBuffer());
        notify();
    }

    public int getBuffer() {
        return buffer;
    }

    public int getTamanhoBuffer() {
        return tamanhoBuffer;
    }

    public void setBuffer(int buffer) {
        this.buffer = buffer;
    }

    public void setTamanhoBuffer(int tamanhoBuffer) {
        this.tamanhoBuffer = tamanhoBuffer;
    }
    
}
