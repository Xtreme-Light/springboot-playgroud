package com.light.tool.fastjson.config.model;

import lombok.Data;

public @Data class Response{
	private String deviceType;
	private String identifier;
	private String iotId;
	private String requestId;
	private CheckFailedData checkFailedData;
	private String name;
	private long time;
	private String type;
	private String productKey;
	private String deviceName;
	private Value value;
}