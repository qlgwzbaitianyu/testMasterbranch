package com.shopping.prac.configuration;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.shopping.prac.shoppingbeans.Product;

import java.io.IOException;

public class ProductSerializer extends StdSerializer<Product> {
    public ProductSerializer(){
        this(null);
    }

    public ProductSerializer(Class<Product> t){
        super(t);
    }

    @Override
    public void serialize(Product value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id", value.getProductId());
        gen.writeStringField("productName", value.getProductName());
        gen.writeStringField("extraMessage", "custom Serializer");
        gen.writeEndObject();
    }
}
