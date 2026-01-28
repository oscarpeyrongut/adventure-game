# Adventure Game - Java Edition

Un jeu d'aventure textuel interactif avec interface graphique développé intégralement en Java.

## Presentation

Ce projet est un jeu de rôle textuel (RPG) où l'utilisateur explore un monde composé de 18 lieux (incluant une mairie, des égouts et diverses salles). Le jeu combine une logique de commandes textuelles avec une interface graphique Swing pour l'affichage des logs et des images.

## Fonctionnalites

- Exploration Narrative : Navigation entre les lieux avec descriptions détaillées et affichage d'images.
- Systeme d'Inventaire :
  - Gestion des objets au sol et dans le sac (ramasser, lâcher).
  - Gestion du poids et de la valeur : l'inventaire a une capacité limitée.
- Mecaniques de Jeu :
  - Le Cookie Magique : Consommer cet objet double la capacité de portage du joueur.
  - Historique de deplacement : Commande permettant de revenir sur ses pas grâce à une pile (Stack) de positions.
  - Limite d'actions : Le joueur dispose d'un maximum de 50 actions pour terminer l'aventure.
- Interface Graphique (GUI) : Fenêtre Swing incluant une zone de texte, un affichage d'image dynamique et un champ de saisie.
- Moteur de Test : Possibilité d'exécuter des scripts de commandes via un fichier texte externe.

## Commandes disponibles

| Commande | Usage |
| :--- | :--- |
| aller [lieu] | Se déplacer vers une direction ou un lieu spécifique. |
| reculer | Retourner dans la pièce précédente. |
| ramasser [objet] | Ajouter un objet de la pièce à l'inventaire. |
| lâcher [objet] | Déposer un objet de l'inventaire dans la pièce actuelle. |
| manger [objet] | Consommer un objet (ex: manger cookie). |
| inventaire | Afficher le contenu du sac, la valeur totale et la capacité max. |
| regarder | Afficher la description du lieu et les objets présents. |
| aide | Lister les commandes et obtenir des instructions. |
| tester [nom] | Exécuter une suite de commandes depuis un fichier texte. |
| quitter | Fermer l'application. |

## Structure du Projet

- Game & GameEngine : Initialisation du jeu et gestion de la logique globale.
- Player : Gestion de l'état du joueur (inventaire, historique, nombre d'actions).
- Room & Item : Modélisation de l'environnement et des objets.
- ItemList : Gestion technique des collections d'objets.
- Parser & Command : Analyse et interprétation des saisies utilisateur.
- UserInterface : Gestion de la fenêtre graphique et des événements Swing.

## Installation et Lancement

1. Prérequis : Java JDK 8 ou supérieur installé sur la machine.
2. Compilation : 
   ```bash
   javac *.java
3. Lancement :
   ```bash
   java Game
