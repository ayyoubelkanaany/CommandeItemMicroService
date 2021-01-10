package ma.irisi.microservice.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@RedisHash("CommandeItem")
public class CommandeItem implements Serializable{
	@Id 
	private Long id;
	private String Produit;
	private Double qte;
	private Double prix;
	private String refCmd;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProduit() {
		return Produit;
	}
	public void setProduit(String produit) {
		Produit = produit;
	}
	public Double getQte() {
		return qte;
	}
	public void setQte(Double qte) {
		this.qte = qte;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public String getRefCmd() {
		return refCmd;
	}
	public void setRefCmd(String refCmd) {
		this.refCmd = refCmd;
	}
	
	

}
