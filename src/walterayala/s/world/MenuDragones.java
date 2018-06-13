/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package walterayala.s.world;

import Dragones.Dragon;
import Gigantes.Gigante;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HP PC
 */
public class MenuDragones {
    public ArrayList<Dragon> escuadronm=new ArrayList<Dragon>();
    public int contador;
    public Jugador jugador;
    public Jugador otro;
    public static MenuDragones menu;
    
     public MenuDragones() {
    }

    public MenuDragones(int contador, Jugador jugador, Jugador otro) {
        this.contador = contador;
        this.jugador = jugador;
        this.otro = otro;
    }

    public Jugador getOtro() {
        return otro;
    }

    public void setOtro(Jugador otro) {
        this.otro = otro;
    }
    
    
    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
     
    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    public static MenuDragones getInstance(){
        if(menu==null){
            menu = new MenuDragones();
        }
        return menu;
    }
    public void Automatico(){
        AbstractFactory factory;
        factory = Produccion.getFactory("Dragones");
        Dragon oro1 = factory.getDragones("Generador de Oro");
        Dragon elixir1 = factory.getDragones("Generador de Elixir");
        Dragon gema1 = factory.getDragones("Generador de Gema");
        Dragon es2 = factory.getDragones("EscuadronM");
        for (int i = 0; i < getJugador().getRe2().size(); i++) {
                        elixir1=getJugador().getRe2().get(i);
                        elixir1.generar();
                
                    }
        for (int i = 0; i < getJugador().getRe2().size(); i++) {
            elixir1 = getJugador().getRe2().get(i);
            int num = elixir1.recolectar();
                        int num1 = getJugador().getMando().getElixir();
                        int sum2 = num + num1; 
                        getJugador().getMando().setElixir(sum2);
                        //System.out.println("Esta esta cantidad de oro " + getJugador().getMando().getOro());

                    }
                    System.out.println("Esta recogió y se obtuvo esta cantidad total en el centro de mando de elixir " + getJugador().getMando().getElixir());
                    for (int i = 0; i < getJugador().getRe1().size(); i++) {
                        System.out.println("Se hizo la generacion "+i);
                        oro1=getJugador().getRe1().get(i);
                        oro1.generar();
                
                    }
                    
                    for (int i = 0; i < getJugador().getRe3().size(); i++) {
                        gema1=getJugador().getRe3().get(i);
                        gema1.generar();
                
                    }
                    for (int i = 0; i < getJugador().getAtacando().size(); i++) {
                        es2 = getJugador().getAtacando().get(i);
                        if (es2.lista() == 1) {
                            int pos = es2.posicion();
                            getOtro().getRe1().get(pos).modificar_vida(5);
                            if (getOtro().getRe1().get(pos).vida() < 1) {
                                System.out.println("Se destruyó el generador " + pos);
                                getOtro().getRe1().remove(pos);
                                System.out.println("El escuadron se pondrá a su disposición para un nuevo ataque");
                                getJugador().getEntrenadas().add(es2);
                                getJugador().getAtacando().remove(i);

                            } else {
                                System.out.println("Sigue con vida el generador de oro numero " + pos);
                            }
                        }
                        else if(es2.lista()==2){
                            int pos=es2.posicion();
                            getOtro().getRe2().get(pos).modificar_vida(5);
                            if (getOtro().getRe2().get(pos).vida() < 1) {
                                System.out.println("Se destruyó el generador " + pos);
                                getOtro().getRe2().remove(pos);
                                System.out.println("El escuadron se pondrá a su disposición para un nuevo ataque");
                                getJugador().getEntrenadas().add(es2);
                                getJugador().getAtacando().remove(i);

                            } else {
                                System.out.println("Sigue con vida el generador de elixir numero " + pos);
                            }
                        }
                        else if(es2.lista()==3){
                            int pos=es2.posicion();
                            getOtro().getRe3().get(pos).modificar_vida(5);
                            if (getOtro().getRe3().get(pos).vida() < 1) {
                                System.out.println("Se destruyó el generador " + pos);
                                getOtro().getRe3().remove(pos);
                                System.out.println("El escuadron se pondrá a su disposición para un nuevo ataque");
                                getJugador().getEntrenadas().add(es2);
                                getJugador().getAtacando().remove(i);

                            } else {
                                System.out.println("Sigue con vida el generador de gemas número " + pos);
                            }
                        }
                        else if(es2.lista()==4){
                            int pos=es2.posicion();
                            getOtro().getEntrenador().get(pos).modificar_vida(5);
                            if (getOtro().getEntrenador().get(pos).vida() < 1) {
                                System.out.println("Se destruyó el  edificio de entrenamiento " + pos);
                                getOtro().getEntrenador().remove(pos);
                                System.out.println("El escuadron se pondrá a su disposición para un nuevo ataque");
                                getJugador().getEntrenadas().add(es2);
                                getJugador().getAtacando().remove(i);

                            } else {
                                System.out.println("Sigue con vida el edificio de entrenamiento numero " + pos);
                            }
                        }
                        else if(es2.lista()==5){
                            int pos=es2.posicion();
                            getOtro().getVehiculo1().get(pos).modificar_vida(5);
                            if (getOtro().getVehiculo1().get(pos).vida() < 1) {
                                System.out.println("Se destruyó el  edificio de vehiculos tipo 1 numero " + pos);
                                getOtro().getVehiculo1().remove(pos);
                                System.out.println("El escuadron se pondrá a su disposición para un nuevo ataque");
                                getJugador().getEntrenadas().add(es2);
                                getJugador().getAtacando().remove(i);

                            } else {
                                System.out.println("Sigue con vida el edificio de vehiculo tipo 1 numero " + pos);
                            }
                        }
                        else if(es2.lista()==6){
                            int pos=es2.posicion();
                            getOtro().getVehiculo2().get(pos).modificar_vida(5);
                            if (getOtro().getVehiculo2().get(pos).vida() < 1) {
                                System.out.println("Se destruyó el  edificio de vehiculos tipo 2 numero " + pos);
                                getOtro().getVehiculo2().remove(pos);
                                System.out.println("El escuadron se pondrá a su disposición para un nuevo ataque");
                                getJugador().getEntrenadas().add(es2);
                                getJugador().getAtacando().remove(i);

                            } else {
                                System.out.println("Sigue con vida el edificio de vehiculo tipo 2 numero " + pos);
                            }
                        }
                        else if(es2.lista()==7){
                            
                        }
                    }
        
    }
    
    public void menuJugador(){
        int opc=0;
        do{
            System.out.println("El Oro a su disposicion es "+getJugador().getMando().getOro());
            System.out.println("El Elixir a su disposicion es "+getJugador().getMando().getElixir());
            System.out.println("Las Gemas a su disposicion es "+getJugador().getMando().getGema());
            System.out.println("\n********JUGADOR********");
            System.out.println("1. Recoger Oro");
            System.out.println("2. Recoger Gemas");
            System.out.println("3. Atacar al rival");
            System.out.println("4. Defender ataque");
            System.out.println("5. Crear generador de Oro");
            System.out.println("6. Crear generador de elixir"); 
            System.out.println("7. Crear generador de gemas"); 
            System.out.println("8. Crear edificacion para entrenar soldados y escuadrones");
            System.out.println("9. Crear edificación para vehiculos 1");
            System.out.println("10. Crear edificación para vehiculos tipo 2");
            System.out.println("11. Mejorar centro de Mando");
            System.out.println("12. Entrenar tropas");
            System.out.println("13. Fin del turno");
            AbstractFactory factory;
            factory = Produccion.getFactory("Dragones");
            Dragon oro1 = factory.getDragones("Generador de Oro");
            Dragon elixir1 = factory.getDragones("Generador de Elixir");
            Dragon gema1 = factory.getDragones("Generador de Gema");
            Dragon es2 = factory.getDragones("EscuadronM");

            Scanner leer = new Scanner(System.in);

            try{
                System.out.println("\nDigite una opcion: ");
                opc = leer.nextInt();
            }
            catch(Exception e){
                System.err.println("\nNo ingresó un numero\n");
            }
            
            switch(opc){    
                case 1:
                    for (int i = 0; i <getJugador().getRe1().size(); i++) {
                        
                        oro1 = getJugador().getRe1().get(i);
                        int num = oro1.recolectar();
                        System.out.println("Esto se obtuvo en "+i+" interaccion "+ num);
                        int num1 = getJugador().getMando().getOro();
                        int sum = num + num1;
                        getJugador().getMando().setOro(sum);
                  
                    }
                    System.out.println("Se recogió y se obtuvo esta cantidad total en el centro de mando de oro " + getJugador().getMando().getOro());
                    break;
                case 2:
                    for (int i = 0; i < getJugador().getRe3().size(); i++) {
                        gema1 = getJugador().getRe3().get(i);
                        int num = gema1.recolectar();
                        int num1 = getJugador().getMando().getGema();
                        int sum = num + num1;
                        getJugador().getMando().setGema(sum);
                    }
                    System.out.println("Se recogió y se obtuvo esta cantidad total en el centro de mando de  gemas " + getJugador().getMando().getGema());
                    break;
                case 3:
                    if (getJugador().getVehiculo2().size() > 0 || getJugador().getVehiculo1().size() > 0) {

                        if (getJugador().getEntrenadas().size() > 0 || getJugador().getUnicoM()[0] != null) {
                            System.out.println("¿Que desea atacar del rival?");
                            System.out.println("1. Generador de Oro");
                            System.out.println("2. Generador de Elixir");
                            System.out.println("3. Generador de Gemas");
                            System.out.println("4. Edificación de entrenamiento");
                            System.out.println("5. Edificacion de vehiculos tipo 1");
                            System.out.println("6. Edificación vehiculos tipo 2");
                            System.out.println("7. Centro de mando");
                            Scanner leern = new Scanner(System.in);
                            Scanner leerv = new Scanner(System.in);
                            int o, v;
                            o = leern.nextInt();
                            int vida1 = 15;
                            int conta = 0;
                            int dis = 1000;
                            int num1=1;
                            int num2=2;
                            System.out.println("¿En qué tipo de vehiculo desea mandar a sus tropas?");
                            System.out.println("1. Vehiculo de tipo 1");
                            System.out.println("2. Vehiculo de tipo 2");
                            v = leerv.nextInt();
                            while (v != num1 && v != num2) {
                                System.out.println("¿En qué tipo de vehiculo desea mandar a sus tropas?");
                                System.out.println("1. Vehiculo de tipo 1");
                                System.out.println("2. Vehiculo de tipo 2");
                                v = leerv.nextInt();
                            }
                            
                            switch (o) {
                                case 1:
                                    if (getOtro().getRe1().size() > 0) {
                                        int cantidad = getOtro().getRe1().size();
                                        Scanner leern2 = new Scanner(System.in);
                                        System.out.println("¿Cuál de los " + cantidad + " generadores de oro desea atacar?");
                                        int pos = leern2.nextInt();
                                        pos = pos - 1;
                                        int o2;
                                        System.out.println("¿Con qué desea atacar?");
                                        System.out.println("1. Con el escuadron");
                                        System.out.println("2. Con Merlin");
                                        o2 = leern.nextInt();
                                        if (o2 == 1) {
                                            if (getJugador().getEntrenadas().size() > 0) {
                                                if (v == 1) {
                                                    if (getJugador().getVehiculo1().size() > 0) {
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo2().size() > 0) {
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    }
                                                }

                                                int tam = getJugador().getEntrenadas().size();
                                                tam = tam - 1;
                                                factory = Produccion.getFactory("Dragones");
                                                Dragon es = factory.getDragones("EscuadronM");
                                                es = getJugador().getEntrenadas().get(tam);
                                                es.modificar_lista(1);
                                                es.modificar_posicion(pos);
                                                getJugador().getAtacando().add(es);
                                                getJugador().getEntrenadas().remove(tam);
                                                getOtro().getRe1().get(pos).modificar_vida(5);
                                                if (getOtro().getRe1().get(pos).vida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene escuadrones disponibles");
                                            }
                                        } else if (o2 == 2) {
                                            if (getJugador().getUnicoM()[0] != null) {
                                                if (v == 1) {
                                                    if (getJugador().getVehiculo1().size() > 0) {
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo2().size() > 0) {
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    }
                                                }

                                                factory = Produccion.getFactory("Dragones");
                                                Dragon esa = factory.getDragones("Merlin");
                                                esa.modificar_lista(1);
                                                esa.modificar_posicion(pos);
                                                getJugador().getAtacando().add(esa);
                                                getOtro().getRe1().get(pos).modificar_vida(20);
                                                if (getOtro().getRe1().get(pos).vida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene a Merlin disponibles");
                                            }

                                        }

                                    } else {
                                        System.out.println("El rival no posee generadores de Oro");
                                    }
                                    break;

                                case 2:
                                    if (getOtro().getRe2().size() > 0) {
                                        int cantidad = getOtro().getRe2().size();
                                        Scanner leern2 = new Scanner(System.in);
                                        System.out.println("¿Cuál de los " + cantidad + " generadores de elixir desea atacar?");
                                        int pos = leern2.nextInt();
                                        pos = pos - 1;
                                        int o2;
                                        System.out.println("¿Con qué desea atacar?");
                                        System.out.println("1. Con el escuadron");
                                        System.out.println("2. Con Merlin");
                                        o2 = leern.nextInt();
                                        if (o2 == 1) {
                                            if (getJugador().getEntrenadas().size() > 0) {
                                                if (v == 1) {
                                                    if (getJugador().getVehiculo1().size() > 0) {
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo2().size() > 0) {
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    }
                                                }

                                                int tam = getJugador().getEntrenadas().size();
                                                tam = tam - 1;
                                                factory = Produccion.getFactory("Dragones");
                                                Dragon es = factory.getDragones("EscuadronM");
                                                es = getJugador().getEntrenadas().get(tam);
                                                es.modificar_lista(2);
                                                es.modificar_posicion(pos);
                                                getJugador().getAtacando().add(es);
                                                getJugador().getEntrenadas().remove(tam);
                                                getOtro().getRe2().get(pos).modificar_vida(5);
                                                if (getOtro().getRe2().get(pos).vida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene escuadrones disponibles");
                                            }
                                        } else if (o2 == 2) {
                                            if (getJugador().getUnicoM()[0] != null) {
                                                if (v == 1) {
                                                    if (getJugador().getVehiculo1().size() > 0) {
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo2().size() > 0) {
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    }
                                                }

                                                getOtro().getRe2().get(pos).modificar_vida(20);
                                                if (getOtro().getRe2().get(pos).vida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene a Merlin disponibles");
                                            }

                                        }

                                    } else {
                                        System.out.println("El rival no posee generadores de Elixir");
                                    }
                                    break;
                                case 3:
                                    if (getOtro().getRe3().size() > 0) {
                                        int cantidad = getOtro().getRe3().size();
                                        Scanner leern2 = new Scanner(System.in);
                                        System.out.println("¿Cuál de los " + cantidad + " generadores de gema desea atacar?");
                                        int pos = leern2.nextInt();
                                        pos = pos - 1;
                                        int o2;
                                        System.out.println("¿Con qué desea atacar?");
                                        System.out.println("1. Con el escuadron");
                                        System.out.println("2. Con Merlin");
                                        o2 = leern.nextInt();
                                        if (o2 == 1) {
                                            if (getJugador().getEntrenadas().size() > 0) {
                                                if (v == 1) {
                                                    if (getJugador().getVehiculo1().size() > 0) {
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo2().size() > 0) {
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    }
                                                }

                                                int tam = getJugador().getEntrenadas().size();
                                                tam = tam - 1;
                                                factory = Produccion.getFactory("Dragones");
                                                Dragon es = factory.getDragones("EscuadronM");
                                                es = getJugador().getEntrenadas().get(tam);
                                                es.modificar_lista(3);
                                                es.modificar_posicion(pos);
                                                getJugador().getAtacando().add(es);
                                                getJugador().getEntrenadas().remove(tam);
                                                getOtro().getRe3().get(pos).modificar_vida(5);
                                                if (getOtro().getRe3().get(pos).vida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene escuadrones disponibles");
                                            }
                                        } else if (o2 == 2) {
                                            if (getJugador().getUnicoM()[0] != null) {
                                                if (v == 1) {
                                                    if (getJugador().getVehiculo1().size() > 0) {
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo2().size() > 0) {
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    }
                                                }

                                                getOtro().getRe3().get(pos).modificar_vida(20);
                                                if (getOtro().getRe3().get(pos).vida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene a Merlin disponibles");
                                            }

                                        }

                                    } else {
                                        System.out.println("El rival no posee generadores de Gema");
                                    }
                                    break;

                                case 4:
                                    if (getOtro().getEntrenador().size() > 0) {
                                        int cantidad = getOtro().getEntrenador().size();
                                        Scanner leern2 = new Scanner(System.in);
                                        System.out.println("¿Cuál de los " + cantidad + " edificios de entrenamiento desea atacar?");
                                        int pos = leern2.nextInt();
                                        pos = pos - 1;
                                        int o2;
                                        System.out.println("¿Con qué desea atacar?");
                                        System.out.println("1. Con el escuadron");
                                        System.out.println("2. Con Merlin");
                                        o2 = leern.nextInt();
                                        if (o2 == 1) {
                                            if (getJugador().getEntrenadas().size() > 0) {
                                                if (v == 1) {
                                                    if (getJugador().getVehiculo1().size() > 0) {
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo2().size() > 0) {
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    }
                                                }

                                                int tam = getJugador().getEntrenadas().size();
                                                tam = tam - 1;
                                                factory = Produccion.getFactory("Dragones");
                                                Dragon es = factory.getDragones("EscuadronM");
                                                es = getJugador().getEntrenadas().get(tam);
                                                es.modificar_lista(4);
                                                es.modificar_posicion(pos);
                                                getJugador().getAtacando().add(es);
                                                getJugador().getEntrenadas().remove(tam);
                                                getOtro().getEntrenador().get(pos).modificar_vida(5);
                                                if (getOtro().getEntrenador().get(pos).vida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene escuadrones disponibles");
                                            }
                                        } else if (o2 == 2) {
                                            if (getJugador().getUnicoM()[0] != null) {
                                                if (v == 1) {
                                                    if (getJugador().getVehiculo1().size() > 0) {
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo2().size() > 0) {
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    }
                                                }

                                                getOtro().getEntrenador().get(pos).modificar_vida(20);
                                                if (getOtro().getEntrenador().get(pos).vida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene a Merlin disponibles");
                                            }

                                        }

                                    } else {
                                        System.out.println("El rival no posee edificaciones de entrenamiento");
                                    }
                                    break;
                                case 5:
                                    if (getOtro().getVehiculo1().size() > 0) {
                                        int cantidad = getOtro().getVehiculo1().size();
                                        Scanner leern2 = new Scanner(System.in);
                                        System.out.println("¿Cuál de los " + cantidad + " vehiculos tipo 1 desea atacar?");
                                        int pos = leern2.nextInt();
                                        pos = pos - 1;
                                        int o2;
                                        System.out.println("¿Con qué desea atacar?");
                                        System.out.println("1. Con el escuadron");
                                        System.out.println("2. Con Merlin");
                                        o2 = leern.nextInt();
                                        if (o2 == 1) {
                                            if (getJugador().getEntrenadas().size() > 0) {
                                                if (v == 1) {
                                                    if (getJugador().getVehiculo1().size() > 0) {
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo2().size() > 0) {
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    }
                                                }

                                                int tam = getJugador().getEntrenadas().size();
                                                tam = tam - 1;
                                                factory = Produccion.getFactory("Dragones");
                                                Dragon es = factory.getDragones("EscuadronM");
                                                es = getJugador().getEntrenadas().get(tam);
                                                es.modificar_lista(5);
                                                es.modificar_posicion(pos);
                                                getJugador().getAtacando().add(es);
                                                getJugador().getEntrenadas().remove(tam);
                                                getOtro().getVehiculo1().get(pos).modificar_vida(5);
                                                if (getOtro().getVehiculo1().get(pos).vida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene escuadrones disponibles");
                                            }
                                        } else if (o2 == 2) {
                                            if (getJugador().getUnicoM()[0] != null) {
                                                if (v == 1) {
                                                    if (getJugador().getVehiculo1().size() > 0) {
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo2().size() > 0) {
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    }
                                                }

                                                getOtro().getVehiculo1().get(pos).modificar_vida(20);
                                                if (getOtro().getVehiculo1().get(pos).vida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene a Merlin disponibles");
                                            }

                                        }

                                    } else {
                                        System.out.println("El rival no posee vehiculos de tipo 1");
                                    }
                                    break;
                                case 6:
                                    if (getOtro().getVehiculo2().size() > 0) {
                                        int cantidad = getOtro().getVehiculo2().size();
                                        Scanner leern2 = new Scanner(System.in);
                                        System.out.println("¿Cuál de los " + cantidad + " vehiculos tipo 2 desea atacar?");
                                        int pos = leern2.nextInt();
                                        pos = pos - 1;
                                        int o2;
                                        System.out.println("¿Con qué desea atacar?");
                                        System.out.println("1. Con el escuadron");
                                        System.out.println("2. Con Merlin");
                                        o2 = leern.nextInt();
                                        if (o2 == 1) {
                                            if (getJugador().getEntrenadas().size() > 0) {
                                                if (v == 1) {
                                                    if (getJugador().getVehiculo1().size() > 0) {
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo2().size() > 0) {
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    }
                                                }

                                                int tam = getJugador().getEntrenadas().size();
                                                tam = tam - 1;
                                                factory = Produccion.getFactory("Dragones");
                                                Dragon es = factory.getDragones("EscuadronM");
                                                es = getJugador().getEntrenadas().get(tam);
                                                es.modificar_lista(6);
                                                es.modificar_posicion(pos);
                                                getJugador().getAtacando().add(es);
                                                getJugador().getEntrenadas().remove(tam);
                                                getOtro().getVehiculo2().get(pos).modificar_vida(5);
                                                if (getOtro().getVehiculo2().get(pos).vida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene escuadrones disponibles");
                                            }
                                        } else if (o2 == 2) {
                                            if (getJugador().getUnicoM()[0] != null) {
                                                if (v == 1) {
                                                    if (getJugador().getVehiculo1().size() > 0) {
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo2().size() > 0) {
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    }
                                                }

                                                factory = Produccion.getFactory("Dragones");
                                                Dragon esa = factory.getDragones("Merlin");
                                                esa.modificar_lista(6);
                                                getJugador().getAtacando().add(esa);
                                                //getJugador().getEntrenadas().remove(tam);
                                                getOtro().getVehiculo2().get(pos).modificar_vida(20);
                                                if (getOtro().getVehiculo2().get(pos).vida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene a Merlin disponibles");
                                            }

                                        }

                                    } else {
                                        System.out.println("El rival no posee vehiculos de tipo 2");
                                    }
                                    break;
                                case 7:
                                    //Terminar este if
                                    if (getOtro().getEntrenador().size() == 0) {

                                        int o2;
                                        System.out.println("¿Con qué desea atacar?");
                                        System.out.println("1. Con el escuadron");
                                        System.out.println("2. Con Merlin");
                                        o2 = leern.nextInt();
                                        if (o2 == 1) {
                                            //Este también
                                            if (getJugador().getEntrenadas().size() > 0) {
                                                if (v == 1) {
                                                    if (getJugador().getVehiculo1().size() > 0) {
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo2().size() > 0) {
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    }
                                                }

                                                int tam = getJugador().getEntrenadas().size();
                                                tam = tam - 1;
                                                factory = Produccion.getFactory("Dragones");
                                                Dragon es = factory.getDragones("EscuadronM");
                                                es = getJugador().getEntrenadas().get(tam);
                                                es.modificar_lista(7);
                                                getJugador().getAtacando().add(es);
                                                getJugador().getEntrenadas().remove(tam);
                                                int vida = getOtro().getMando().getVida();
                                                vida = vida - 5;
                                                getOtro().getMando().setVida(vida);
                                                //getOtro().getMando().getVida().modificar_vida(5);
                                                if (getOtro().getMando().getVida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene escuadrones disponibles");
                                            }
                                        } else if (o2 == 2) {
                                            if (getJugador().getUnicoM()[0] != null) {
                                                if (v == 1) {
                                                    if (getJugador().getVehiculo1().size() > 0) {
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo2().size() > 0) {
                                                        getJugador().getVehiculo2().remove(getJugador().getVehiculo2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo1().remove(getJugador().getVehiculo1().size() - 1);
                                                    }
                                                }

                                                int vida = getOtro().getMando().getVida();
                                                vida = vida - 20;
                                                getOtro().getMando().setVida(vida);
                                                if (getOtro().getMando().getVida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene a Merlin disponibles");
                                            }

                                        }

                                    } else {
                                        System.out.println("No has acabado con todas las edificaciones enemigas");
                                    }
                                    break;


                            }

                        } else {
                            System.out.println("No tiene tropas entrenadas");
                        }
                    } else {
                        System.out.println("No tiene vehiculos disponibles para atacar");
                    }
                    break;

                            
                case 4:
                    if (getOtro().getAtacando().size() > 0 /*&& getJugador().getEntrenadas().size()>0*/) {
                        Scanner def = new Scanner(System.in);
                        System.out.println("¿Con qué desea defender?");
                        System.out.println("1. Un escuadron");
                        System.out.println("2. De Merlin");
                        int op4 = def.nextInt();
                        Scanner defop = new Scanner(System.in);
                        System.out.println("Cual de los " + getOtro().getAtacando().size() + " escuadrones del rival desea atacar");
                        int op41 = defop.nextInt();
                        op41=op41-1;

                        switch (op4) {
                            case 1:
                                if (getJugador().getEntrenadas().size() > 0) {
                                    factory = Produccion.getFactory("Dragones");
                                    Dragon esc = factory.getDragones("EscuadronM");
                                    esc = getJugador().getEntrenadas().get(getJugador().getEntrenadas().size() - 1);
                                    esc.modificar_posicion(op41);
                                    esc.modificar_lista(8);
                                    getOtro().getAtacando().get(op41).modificar_vida(5);
                                    if (getOtro().getAtacando().get(op41).vida() < 1) {
                                        System.out.println("Se destruyó la tropa enemiga");
                                        getOtro().getAtacando().remove(op41);
                                        System.out.println("Su tropa vuelve a estar a su disposición nuevamente");
                                    } else {
                                        System.out.println("Sigue con vida");
                                    }
                                } else {
                                    System.out.println("No dispone de tropas entrenadas");
                                }
                                break;
                            case 2:
                                if (getJugador().getUnicoM()[0] != null) {
                                    factory = Produccion.getFactory("Dragones");
                                    Dragon esc = factory.getDragones("Merlin");
                                    esc = getJugador().getUnicoM()[0];
                                    esc.modificar_lista(8);
                                    esc.modificar_posicion(op41);
                                    getOtro().getAtacando().get(op41).modificar_vida(20);
                                    if (getOtro().getAtacando().get(op41).vida() < 1) {
                                        System.out.println("Se destruyó la tropa enemiga");
                                        getOtro().getAtacando().remove(op41);
                                        System.out.println("Su tropa vuelve a estar a su disposición nuevamente");
                                    } else {
                                        System.out.println("Sigue con vida");
                                    }
                                } else {
                                    System.out.println("No tiene entrenado a Merlin");
                                }
                                break;
                        }
                    } else {
                        System.out.println("El rival no tiene tropas en ataque");
                    }
                    break;
                case 5:
                    factory = Produccion.getFactory("Dragones");
                    Dragon oro = factory.getDragones("Generador de Oro");
                    getJugador().getRe1().add(oro);
                    System.out.println("Se construyó un generador de oro");
                    break;
                case 6:
                    factory = Produccion.getFactory("Dragones");
                    Dragon elixir = factory.getDragones("Generador de Elixir");
                    getJugador().getRe2().add(elixir);
                    //generador_elixir.add(elixir);
                    System.out.println("Se construyó un generador de Elixir");
                    break;
                case 7:
                    factory = Produccion.getFactory("Dragones");
                    Dragon gema = factory.getDragones("Generador de Gema");
                    getJugador().getRe3().add(gema);
                    //generador_gema.add(gema);
                    System.out.println("Se construyó un generador de gema");
                    break;
                case 8:
                    factory = Produccion.getFactory("Dragones");
                    Dragon entrena = factory.getDragones("Entrenador");
                    entrena.estado();
                    getJugador().getEntrenador().add(entrena);
                    //entrenar.add(entrena);
                    System.out.println("Se construyó una edificación para entrenar");
                    
                    break;
                case 9:
                    factory = Produccion.getFactory("Dragones");
                    Dragon veh1 = factory.getDragones("Alfombra");
                    getJugador().getVehiculo1().add(veh1);
                    //vehiculo1.add(veh1);
                    System.out.println("Se construyó un vehiculo tipo 1");
                    break;
                    
                case 10:
                    factory = Produccion.getFactory("Dragones");
                    Dragon veh2 = factory.getDragones("Caballo");
                    getJugador().getVehiculo2().add(veh2);
                    //vehiculo2.add(veh2);
                    System.out.println("Se construyó un vehiculo tipo 2");
                    break;
                case 11:
                    int cap1=getJugador().getMando().getCapacidad1();
                    int cap2=getJugador().getMando().getCapacidad2();
                    int cap3=getJugador().getMando().getCapacidad3();
                    double ca=cap1+(cap1*0.10); 
                    double ce=cap2+(cap2*0.30); 
                    double ci=cap3+(cap3*0.50); 
                    double sum= (ca+ce+ci);
                    sum=sum*0.25;
                    sum=(int)sum/3;
                    
                    System.out.println(sum);
                    
                    if (getJugador().getMando().getOro() >= sum && getJugador().getMando().getElixir() >= sum && getJugador().getMando().getGema() >= sum) {
                        getJugador().getMando().level(ca,ce,ci);
                        
                        int num1 = getJugador().getMando().getOro();
                        double res = num1 - sum;
                        getJugador().getMando().setOro((int)res);
                        int num2 = getJugador().getMando().getElixir();
                        double res2 = num2 - sum;
                        getJugador().getMando().setElixir((int)res2);
                        int num3 = getJugador().getMando().getGema();
                        double res3 = num3 - sum;
                        getJugador().getMando().setGema((int)res3);
                    
                        
                        System.out.println("El valor de almacenaje ahora de Oro es de " + getJugador().getMando().getCapacidad1());
                        System.out.println("El valor de almacenaje ahora de Elixir es de " + getJugador().getMando().getCapacidad2());
                        System.out.println("El valor de almacenaje ahora de Gema es de " + getJugador().getMando().getCapacidad3());
                    }
                    else{
                        System.out.println("No dispone de suficientes recursos");
                    }
                    break;
                    
                case 12:
                    int k = 0;
                    int sup=1000;
                    boolean sta = false;
                    factory = Produccion.getFactory("Dragones");
                    Dragon entrenad = factory.getDragones("Entrenador");
                    //sta=getJugador().getEntrenador().get(k).question();
                    System.out.println(getJugador().getEntrenador().size() > 0);
                    
                    if (getJugador().getEntrenador().size() > 0) {

                        while (k < getJugador().getEntrenador().size()) {
                            if (getJugador().getEntrenador().get(k).question() != true) {
                                k = k + 1;
                            } else {
                                sup = k;
                                k=getJugador().getEntrenador().size();
                            }

                        }

                        if (sup!=1000) {
                            System.out.println("¿Qué numero de tropa desea entrenar?");
                            System.out.println("1. Escuadron M");
                            System.out.println("2. Merlin");
                            Scanner leer2 = new Scanner(System.in);
                            int op = leer2.nextInt();
                            if (op == 1) {
                                factory = Produccion.getFactory("Dragones");
                                Dragon escua = factory.getDragones("EscuadronM");
                                escua.entrenar();
                                getJugador().getEntrenadas().add(escua);
                                getJugador().getEntrenador().get(sup).estado();
                                System.out.println("Se entrenó un EscuadonM");
                            } else if (op == 2) {
                                if (getJugador().getUnicoM()[0] == null) { 
                                    factory = Produccion.getFactory("Dragones");
                                    Dragon me = factory.getDragones("Merlin");
                                    getJugador().getUnicoM()[0] = me;
                                    System.out.println("Se entrenó a Merlin");
                                    getJugador().getEntrenador().get(sup).estado();
                                } else {
                                    System.out.println("Solo se puede tener a un Merlin entrenado");
                                }
                            } else {
                                System.out.println("No eligió ninguna opción");
                            }
                        } else {
                            System.out.println("No hay edificación para entrenar disponible");
                        }
                    } else {
                        System.out.println("No tiene edificaciones de entrenamiento");
                    }


                    
                    break;
                    
                case 13:
                   
                    System.out.println("Tienes "+ getJugador().getEntrenador().size() + " Para entrenar tropas");
                    System.out.println("Tienes "+ getJugador().getVehiculo1().size() + " vehiculo tipo 1");
                    System.out.println("Tienes "+ getJugador().getVehiculo2().size() + " vehiculo tipo 2 ");
                    //cont=cont+1;
                    //System.exit(0);
                    break;
                default:
                     System.out.println("");
            }
        }while(opc!=13);       
    }
}

