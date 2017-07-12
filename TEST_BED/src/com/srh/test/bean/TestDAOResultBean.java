package com.srh.test.bean;



import java.io.Serializable;
import java.util.HashMap;

import javax.websocket.Decoder.Binary;

public class TestDAOResultBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String clId;
	String smId;
	int slNo; 
	int sLNoFrom;
	int sLNoTo;
	String reqtId;
	String condId;
	String subCondId;
	String logicId;
	String fnId;
	String query;
	String objName;
	HashMap objValue;

	public String getClId() {
		return clId;
	}
	public void setClId(String clId) {
		this.clId = clId;
	}
	public String getSmId() {
		return smId;
	}
	public void setSmId(String smId) {
		this.smId = smId;
	}
	public int getSlNo() {
		return slNo;
	}
	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}
	public int getsLNoFrom() {
		return sLNoFrom;
	}
	public void setsLNoFrom(int sLNoFrom) {
		this.sLNoFrom = sLNoFrom;
	}
	public int getsLNoTo() {
		return sLNoTo;
	}
	public void setsLNoTo(int sLNoTo) {
		this.sLNoTo = sLNoTo;
	}
	public String getReqtId() {
		return reqtId;
	}
	public void setReqtId(String reqtId) {
		this.reqtId = reqtId;
	}
	public String getCondId() {
		return condId;
	}
	public void setCondId(String condId) {
		this.condId = condId;
	}
	public String getSubCondId() {
		return subCondId;
	}
	public void setSubCondId(String subCondId) {
		this.subCondId = subCondId;
	}
	public String getLogicId() {
		return logicId;
	}
	public void setLogicId(String logicId) {
		this.logicId = logicId;
	}
	public String getFnId() {
		return fnId;
	}
	public void setFnId(String fnId) {
		this.fnId = fnId;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getObjName() {
		return objName;
	}
	public void setObjName(String objName) {
		this.objName = objName;
	}
	public HashMap getObjValue() {
		return objValue;
	}
	public void setObjValue(HashMap objValue) {
		this.objValue = objValue;
	}
	
	

}
