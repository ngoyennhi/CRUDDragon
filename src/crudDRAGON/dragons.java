package crudDRAGON;

public class dragons {
private int id;
private String dragon;
private String sexe;
private int longueur;
private int nombreEcailles;
private String cracheDuFeu;
private String comportementAmoureux;
@Override
public String toString() {
	return "dragons [id=" + id + ", longueur=" + longueur + ", nombreEcailles=" + nombreEcailles + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDragon() {
	return dragon;
}
public void setDragon(String dragon) {
	this.dragon = dragon;
}
public String getSexe() {
	return sexe;
}
public void setSexe(String sexe) {
	this.sexe = sexe;
}
public int getLongueur() {
	return longueur;
}
public void setLongueur(int longueur) {
	this.longueur = longueur;
}
public int getNombreEcailles() {
	return nombreEcailles;
}
public void setNombreEcailles(int nombreEcailles) {
	this.nombreEcailles = nombreEcailles;
}
public String getCracheDuFeu() {
	return cracheDuFeu;
}
public void setCracheDuFeu(String cracheDuFeu) {
	this.cracheDuFeu = cracheDuFeu;
}
public String getComportementAmoureux() {
	return comportementAmoureux;
}
public void setComportementAmoureux(String comportementAmoureux) {
	this.comportementAmoureux = comportementAmoureux;
}


}
