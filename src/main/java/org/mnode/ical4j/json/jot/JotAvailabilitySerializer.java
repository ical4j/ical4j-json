package org.mnode.ical4j.json.jot;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import net.fortuna.ical4j.model.component.VAvailability;

import java.io.IOException;

public class JotAvailabilitySerializer extends StdSerializer<VAvailability> {

    public JotAvailabilitySerializer(Class<VAvailability> t) {
        super(t);
    }

    @Override
    public void serialize(VAvailability value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeTree(buildAvailability(value));
    }

    private JsonNode buildAvailability(VAvailability availability) {
        AbstractJotBuilder<VAvailability> builder = new AvailabilityBuilder().component(availability);
        return builder.build();
    }
}
