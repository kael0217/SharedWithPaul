package com.java.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.java.dto.Address;

public class CustomAddressSerializer extends StdSerializer<Address>{
//	private static SimpleDateFormat formatter 
//    = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

  public CustomAddressSerializer() { 
      this(null); 
  } 

  public CustomAddressSerializer(Class<Address> t) {
      super(t); 
  }

  @Override
  public void serialize(
    Address address, JsonGenerator gen, SerializerProvider arg2) 
    throws IOException, JsonProcessingException {
	  String outputString = Integer.toString(address.getHno())+" "+address.getStreet()+". "+address.getCity()+ ", "+address.getState();
      gen.writeString(outputString);
  }
}
