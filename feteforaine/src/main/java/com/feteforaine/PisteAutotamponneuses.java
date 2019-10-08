package com.feteforaine;

public class PisteAutotamponneuses{
    Autotamponneuse[] tabAutotamponneuses;
    int size;

    public PisteAutotamponneuses(int pSize){
        size = pSize;
        tabAutotamponneuses = new Autotamponneuse[size];
    }

    public void instantiateAuto(){
        for (int i=0; i<size; i++){ // Pour chaque autotamponneuse
            tabAutotamponneuses[i] = new Autotamponneuse(Math.random()*100, Math.random()*100);
            for (int j=0; j<i-1; j++){ // Pour chaque auto tamponneuse déjà créée
                if(tabAutotamponneuses[j].collision(tabAutotamponneuses[i])){
                    tabAutotamponneuses[i] = null;
                    i--;
                }   
            }
            System.out.println(tabAutotamponneuses[i].toString());
        }
    }

    public static void main(String[] args) {
        PisteAutotamponneuses pAuto = new PisteAutotamponneuses(10);
        pAuto.instantiateAuto();
    }
}