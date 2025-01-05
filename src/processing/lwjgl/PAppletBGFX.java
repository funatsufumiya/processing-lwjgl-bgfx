package processing.lwjgl;

import org.lwjgl.bgfx.BGFX;
import static org.lwjgl.bgfx.BGFX.*;

import processing.core.PApplet;

public class PAppletBGFX extends PApplet {
    int viewId = 0;

    // protected void background_hex(int rgba, float depth){
    //     // System.out.println("background_hex(" + rgba + ", " + depth + ")");
    //     // print rgba as hex
    //     // System.out.println("background_hex(" + Integer.toHexString(rgba) + ", " + depth + ")");

    //     // NOTE: currently does not clear depth here.
    //     BGFX.bgfx_set_view_clear(viewId, BGFX_CLEAR_COLOR, rgba, depth, 0);
    // }

    protected void background_hex(int rgba){
        // background_hex(rgba, 1.0f);

        // NOTE: currently does not clear depth here.
        BGFX.bgfx_set_view_clear(viewId, BGFX_CLEAR_COLOR, rgba, 1.0f, 0);
    }

    // NOTE: currently treat v1 as r, v2 as g, v3 as b
    // r: 0-255, g: 0-255, b: 0-255

    @Override
    public void background(float r, float g, float b, float a) {
        int rgba = ((int)(r) << 24) | ((int)(g) << 16) | ((int)(b) << 8) | ((int)(a));
        background_hex(rgba);
    }

    @Override
    public void background(float r, float g, float b) {
        background(r, g, b, 255);
    }

    @Override
    public void background(float gray, float alpha) {
        background(gray, gray, gray, alpha);
    }

    @Override
    public void background(float gray) {
        background(gray, gray, gray, 255);
    }
}