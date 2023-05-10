package be.unamur.uppaal.juppaal.declarations;

import java.util.Objects;

public class Channel {
    private final String name;
    private final String scope;
    private final ChanType type;
    public Channel(String name, String scope, ChanType type) {
        this.name = name;
        this.type = type;
        this.scope = scope;
    }

    public static enum ChanType {
        BROADCAST,
        URGENT,
        BINARY
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Channel)) {
            return false;
        }

        Channel chan = (Channel) o;

        if (!this.name.equals(chan.getName())) {
            return false;
        }

        if (!this.type.equals(chan.getType())) {
            return false;
        }

        return this.scope.equals(chan.getScope());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, scope, type);
    }

    @Override
    public String toString() {
        return "Channel{" +
                "name='" + name + '\'' +
                ", scope='" + scope + '\'' +
                ", type=" + type +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getScope() {
        return scope;
    }

    public ChanType getType() {
        return type;
    }
}
