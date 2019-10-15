package com.example.MockHackathon.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountView {

	private String id;

    @JsonProperty("short_name")
    private String shortName;

    private String description;

    @JsonProperty("is_public")
    private Boolean isPublic;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}
    
}
