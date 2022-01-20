package crudDRAGON;

public class dragons {
private int id;
private String nomDragon; 
private String sexeDragon; 
private int longDragon;
private int scalesDragon;
private String spitFireDragon;
private String behaviorDragon;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNomDragon() {
	return nomDragon;
}
public void setNomDragon(String nomDragon) {
	this.nomDragon = nomDragon;
}
public String getSexeDragon() {
	return sexeDragon;
}
public void setSexeDragon(String sexeDragon) {
	this.sexeDragon = sexeDragon;
}
public int getLongDragon() {
	return longDragon;
}
public void setLongDragon(int longDragon) {
	this.longDragon = longDragon;
}
public int getScalesDragon() {
	return scalesDragon;
}
public void setScalesDragon(int scalesDragon) {
	this.scalesDragon = scalesDragon;
}
public String getSpitFireDragon() {
	return spitFireDragon;
}
public void setSpitFireDragon(String spitFireDragon) {
	this.spitFireDragon = spitFireDragon;
}
public String getBehaviorDragon() {
	return behaviorDragon;
}
public void setBehaviorDragon(String behaviorDragon) {
	this.behaviorDragon = behaviorDragon;
}
// used to public result
@Override
public String toString() {
	return "dragons [id=" + id + ", nomDragon=" + nomDragon + ", sexeDragon=" + sexeDragon + ", longDragon="
			+ longDragon + ", scalesDragon=" + scalesDragon + ", spitFireDragon=" + spitFireDragon + ", behaviorDragon="
			+ behaviorDragon + "]";
}



}
