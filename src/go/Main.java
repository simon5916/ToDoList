package go;

import bo.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Task> taskList = new ArrayList<Task>();
    static List<Task> historicList = new ArrayList<Task>();
    Task defaultTask = new Task("Tâche par défaut", "Un exemple de tâche", true);


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	    int item = 9; //initialisation de item à un nombre qui ne rentre pas dans un cas
        while(item != 0){ //tant que l'on a pas appuyé sur 0 (qui est le choix de quitter), on ne part pas
            item=menu();
            switch(item){
                case 1:
                    showList(); //Afficher les tâches
                    break;
                case 2:
                    addItem(); //Ajouter une tâche
                    break;
                case 3:
                    deleteItem(); //Supprimer une tâche
                    break;
                case 4:
                    validateItem();//Valider une tâche
                    break;
                case 5:
                    showHistoricList();
                case 0:
                    break; //Sortir et accepter de valider le module du génial créateur de ce programme
                default: // Indiquer que l'entrée est invalide
                    System.out.println("L'entrée sélectionnée n'existe pas, recommencez.");
            }
        }
    }





    public static int menu(){
        int options;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------- \n");
        System.out.println("    Bienvenue dans la nouvelle & révolutionnaire application de To Do List !!! \n");
        System.out.println("----------------------------------------------------------------------------- \n");
        System.out.println("Dans cette application vous pouvez ajouter, supprimer, afficher toutes les tâches que vous avez créer sans aucune limite!\n");
        System.out.println("Dans le terminal sélectionez l'option que vous souhaitez utiliser:\n");
        System.out.println("1: Afficher la liste de vos tâche en cours \n");
        System.out.println("2: Ajouter une nouvelle tâche à effectuer \n");
        System.out.println("3 : Supprimer une tâche \n");
        System.out.println("4 : Valider une tâche \n");
        System.out.println("5 : Voir votre historique de tâche \n");
        System.out.println("0: Quitter cette merveilleuse application et accepter de valider le module du créateur :) \n");
        System.out.println("Choisissez ce que vous souhaiter faire: \n");
        options = keyboard.nextInt();
        return options;
    }

    public static void showList(){
        System.out.println("Votre liste de chose à faire: \n");
        if(taskList.size()==0){
            System.out.println("votre liste est vide!");
        } else {
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println(i+1 + " " + taskList.get(i).getTaskName()+ " " +
                taskList.get(i).getTaskDescription()+ " " +
                taskList.get(i).isStateValidate()); // récup les elements de la liste
            }
        }
    }

    public static void addItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vous souhaitez ajouter une tâche:");
        System.out.println("Quelle nom donner à cette tâche ?");
        String name = scanner.nextLine();
        System.out.println("Quelle description donner à cette tâche ?");
        String desc= scanner.nextLine();
        taskList.add(new Task(name,desc,false));
        System.out.println("La tâche à été ajoutée avec succès");
        showList();
    }

    public static void deleteItem(){
        System.out.println("Vous souhaitez supprimer une tâche:");
        Scanner TaskSelection = new Scanner(System.in);
        System.out.println("Vous souhaitez supprimer quelle tâche ?");
        int index = TaskSelection.nextInt();
        if ((index-1)<0 || index>taskList.size()){
            System.out.println("L'index sélectionné n'existe pas");
        } else{

            historicList.add(taskList.get(index-1));
            taskList.remove(index-1);
            System.out.println("La tâche à été supprimée avec succès");
            System.out.println("Voici votre liste des tâches:");
        }
        showList();
    }

    public static void validateItem(){
        System.out.println("Vous souhaitez valider une tâche:");
        Scanner TaskSelection = new Scanner(System.in);
        System.out.println("Vous souhaitez valider quelle tâche ? ");
        int index = TaskSelection.nextInt();
        if ((index-1)<0 || index>taskList.size()){
            System.out.println("L'index sélectionné n'existe pas");
        } else{
            taskList.get(index-1).setStateValidate();
            System.out.println("La tâche à été validée avec succès");
            System.out.println("Voici votre liste des tâches:");
        }
        showList();
    }

    public static void showHistoricList(){
        System.out.println("Votre historique: \n");
        if(historicList.size()==0){
            System.out.println("votre historique est vide!");
        } else {
            for (int i = 0; i < historicList.size(); i++) {
                System.out.println(i+1 + " " + historicList.get(i).getTaskName()+ " " +
                        historicList.get(i).getTaskDescription()+ " " +
                        historicList.get(i).isStateValidate()); // récup les elements de la liste
            }
        }
    }









}
