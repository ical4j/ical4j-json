package org.mnode.ical4j.json.jot;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import net.fortuna.ical4j.model.component.VFreeBusy;

import java.io.IOException;

public class JotFreeBusySerializer extends StdSerializer<VFreeBusy> {

    public JotFreeBusySerializer(Class<VFreeBusy> t) {
        super(t);
    }

    @Override
    public void serialize(VFreeBusy value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeTree(buildFreebusy(value));
    }

    private JsonNode buildFreebusy(VFreeBusy freeBusy) {
        AbstractJotBuilder<VFreeBusy> builder = new FreebusyBuilder().component(freeBusy);
        return builder.build();
    }
}
