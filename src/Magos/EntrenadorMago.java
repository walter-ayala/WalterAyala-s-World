/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Magos;

/**
 *
 * @author HP PC
 */
public class EntrenadorMago implements Raza {
    public boolean estado=false;
    public int vida=25;
    public int lista=0;
    public int posicion=0;

    public int getLista() {
        return lista;
    }

    public void setLista(int lista) {
        this.lista = lista;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    @Override
    public void atacar() {
    }

    @Override
    public void defender() {
    }

    @Override
    public void construir() {
        System.out.println("Se ha construido una edificacion de Entrenamiento de Magos");}

    @Override
    public int recolectar() {
        return 0;
    }

    @Override
    public void generar() {
    }


    @Override
    public int vida() {
        return vida;
    }

    @Override
    public boolean entrenar() {
    if(estado==false){
            setEstado(true);
        }
        else{
            setEstado(false);
        }
    return estado;
    }

    @Override
    public boolean estado() {
    if(estado==false){
            setEstado(true);
        }
        else{
            setEstado(false);
        }
    return estado;
    }

    @Override
    public boolean question() {
        return estado;
    }

    @Override
    public int nombre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int fase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int modificar_vida(int num) {
        setVida(vida-num);
        return vida;
    }

    @Override
    public int lista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int posicion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar_lista(int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar_posicion(int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void generar_doble() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vida_inicial() {
        setVida(getVida() * 2);
    }

}
