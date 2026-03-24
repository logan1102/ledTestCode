package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.LEDPattern;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.TeamColor;

public class boringLeds extends SubsystemBase {
        // an led strip
    private AddressableLED led;
    // how many leds on the strip
    private int length;
    // a buffer with data on the led strip states
    private AddressableLEDBuffer buffer;

    public boringLeds(){
        this.length = 60;

        this.led = new AddressableLED(0);
        buffer = new AddressableLEDBuffer(length);

        led.setLength(length);
        led.setData(buffer);
        led.start();
    }

    public void updateData(){
        led.setData(buffer);
    }

    @Override
    public void periodic(){
        led.setData(buffer);
    }


    public Command setLedsCommands(TeamColor color){
       return runOnce(()->setLeds(color));
    }


    public void setLeds(TeamColor color){
        for (int i = 0; i < length; i++){
            buffer.setRGB(i, color.r, color.g, color.b);
        }
        this.updateData();
    }
}
