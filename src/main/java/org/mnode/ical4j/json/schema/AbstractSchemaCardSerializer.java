package org.mnode.ical4j.json.schema;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import net.fortuna.ical4j.vcard.VCard;

import java.io.IOException;

public abstract class AbstractSchemaCardSerializer extends StdSerializer<VCard> {

    public AbstractSchemaCardSerializer(Class<VCard> t) {
        super(t);
    }

    @Override
    public void serialize(VCard value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeTree(buildSchema(value));
    }

    protected abstract JsonNode buildSchema(VCard card);
}
