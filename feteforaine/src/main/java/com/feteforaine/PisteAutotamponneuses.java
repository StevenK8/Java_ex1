package com.feteforaine;

public class PisteAutotamponneuses{
    private Autotamponneuse[] tabAutotamponneuses;
    private int size;
    private int destroyCount;

    public PisteAutotamponneuses(int pSize){
        size = pSize;
        tabAutotamponneuses = new Autotamponneuse[size];
    }

    public void instantiateAuto(){
        for (int i=0; i<size; i++){ // Pour chaque autotamponneuse
            tabAutotamponneuses[i] = new Autotamponneuse(Math.random()*100, Math.random()*100);
            tabAutotamponneuses[i].ajouteOccupant("adversaire"+(i+1));
            for (int j=0; j<i-1; j++){ // Pour chaque auto tamponneuse déjà créée
                if(tabAutotamponneuses[j].collision(tabAutotamponneuses[i])){
                    tabAutotamponneuses[i].removeId();
                    tabAutotamponneuses[i] = null;
                    i--;
                }   
            }
            //System.out.println(tabAutotamponneuses[i].toString());
        }
    }

    public static void main(String[] args) {
        PisteAutotamponneuses pAuto = new PisteAutotamponneuses(11);
        pAuto.instantiateAuto();
        System.out.println(pAuto.toString());

        int vainqueur=pAuto.dereglementAleatoire();
        if(vainqueur!=-1){
            System.out.println("Le vainqueur est "+ vainqueur);
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for(int i=0; i<this.size; i++){
            str.append(tabAutotamponneuses[i].toString()+"\n");
        }
        return str.toString();
    }

    public int dereglementAleatoire(){
        int idVainqueur = -1;
        while(size-destroyCount>1){
            for(int i=0; i<this.size; i++){
                if (!tabAutotamponneuses[i].isDestroyed()){
                    tabAutotamponneuses[i].moveRandom();
                    for(int j=0; j<this.size; j++){
                        if (!tabAutotamponneuses[j].isDestroyed()){
                            if (j!=i){
                                if(tabAutotamponneuses[i].collision(tabAutotamponneuses[j])){
                                    tabAutotamponneuses[i].destroy();
                                    destroyCount++;
                                    System.out.println(tabAutotamponneuses[i].toStringSimple() + " a heurté " + tabAutotamponneuses[j].toStringSimple());
                                    tabAutotamponneuses[j].destroy();
                                    destroyCount++;
                                }
                            }
                        }

                    }
                }

            }
        }
        for(int i=0; i<this.size; i++){
            if (!tabAutotamponneuses[i].isDestroyed())
                idVainqueur = i+1;
        }
        return idVainqueur;
    }
}