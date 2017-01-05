package com.internet.journal.ua.domain;

import java.sql.Timestamp;

public class Journal {
	private int id;
	private String name;
	private String description;
	private Timestamp dataCreate;
	private Timestamp modifJournal;
	private JournalType type;
	private int price;
	private boolean isDelited;
	
	public enum JournalType{
		ANIMAL, MOVIES, MUSIC, CARS; //add rest of it
	}
	public Journal() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getDataCreate() {
		return dataCreate;
	}
	public void setDataCreate(Timestamp dataCreate) {
		this.dataCreate = dataCreate;
	}
	public Timestamp getModifJournal() {
		return modifJournal;
	}
	public void setModifJournal(Timestamp modifJournal) {
		this.modifJournal = modifJournal;
	}
	public JournalType getType() {
		return type;
	}
	public void setType(JournalType type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isDelited() {
		return isDelited;
	}
	public void setDelited(boolean isDelited) {
		this.isDelited = isDelited;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataCreate == null) ? 0 : dataCreate.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + (isDelited ? 1231 : 1237);
		result = prime * result + ((modifJournal == null) ? 0 : modifJournal.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Journal other = (Journal) obj;
		if (dataCreate == null) {
			if (other.dataCreate != null)
				return false;
		} else if (!dataCreate.equals(other.dataCreate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (isDelited != other.isDelited)
			return false;
		if (modifJournal == null) {
			if (other.modifJournal != null)
				return false;
		} else if (!modifJournal.equals(other.modifJournal))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Journal [id=" + id + ", name=" + name + ", description=" + description + ", dataCreate=" + dataCreate
				+ ", modifJournal=" + modifJournal + ", type=" + type + ", price=" + price + ", isDelited=" + isDelited
				+ "]";
	}

	
	

}
