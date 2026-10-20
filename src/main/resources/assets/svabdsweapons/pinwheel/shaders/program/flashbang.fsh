uniform sampler2D DiffuseSampler0;

uniform float u_Time;

in vec2 texCoord;

out vec4 fragColor;

void main() {
    float timeSinceStart = u_time - u_startTime;

    fragColor = vec4(1,1,1,1);
}