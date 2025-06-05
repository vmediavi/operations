package com.example.operations.controller.dto;


import com.fasterxml.jackson.databind.JsonNode;

public class OperationConfigDTO {
    private String name;
    private JsonNode configJson;
    private boolean active;

    public String getName() {
        return name;
    }

    public OperationConfigDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getConfigJson() {
        return configJson.toString();
    }

    public OperationConfigDTO setConfigJson(JsonNode configJson) {
        this.configJson = configJson;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public OperationConfigDTO setActive(boolean active) {
        this.active = active;
        return this;
    }

}