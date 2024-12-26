## Processing LWJGL Library BGFX Fork

This is based on [processing-lwjgl](https://github.com/codeanticode/processing-lwjgl)

### Current Status

- [x] `./gradlew runHelloBGFX` works (this don't use the Processing API)
- [x] show blank window
- [ ] `./gradlew runBackground` works << DOING >>
- [ ] Texture
- [ ] FBO
- [ ] Background (Clear)
- [ ] Image
- [ ] Shader
- [ ] 2D: Rect
- [ ] 2D: Line
- [ ] 2D: Ellipse
- [ ] 3D: Camera (LookAt)
- [ ] 3D: Light (Basic)
- [ ] 3D: Box
- [ ] 3D: Sphere

NOTE: Currently, most of the PLWJGL code is commented out, and throws `NotImplementedException` when called.

### Run

#### Processing Example

```
./gradlew buildExample
./gradlew runSketch
```

#### Plain GLFW/BGFX Example

```
./gradlew buildHelloBGFX
./gradlew runHelloBGFX
```


-----

## Processing LWJGL library

This is a Processing library that offers LWJGL-based 2D and 3D renderers. [LWJGL](https://www.lwjgl.org/) is a Java library that enables cross-platform access to graphics APIs.
