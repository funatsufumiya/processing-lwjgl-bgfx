package processing.lwjgl.internal;

public enum BGFXRendererType {
    NOOP(0),
    AGC(1),
    DIRECT3D11(2),
    DIRECT3D12(3),
    GNM(4),
    METAL(5),
    NVN(6),
    OPENGLES(7),
    OPENGL(8),
    VULKAN(9)
    ;
    public final int value;
    private BGFXRendererType(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public int getCount() {
        return values().length;
    }
    public static BGFXRendererType valueOf(int value) {
        for (BGFXRendererType format : values()) {
            if (format.value == value) {
                return format;
            }
        }
        return null;
    }
}