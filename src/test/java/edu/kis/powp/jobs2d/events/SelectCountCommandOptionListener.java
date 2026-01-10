package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.features.CommandsFeature;
import edu.kis.powp.jobs2d.visitor.CounterVisitor;

/**
 * Listener implementation that counts the number of atomic commands in the current command using CounterVisitor.
 */
public class SelectCountCommandOptionListener implements ActionListener {

    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * Triggered when the action is performed.
     * Retrieves the current command, counts its sub-commands, and logs the result.
     * @param e the action event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        DriverCommand command = CommandsFeature.getDriverCommandManager().getCurrentCommand();

        if (command == null) {
            logger.warning("No command loaded.");
            return;
        }

        logger.info("The command consists of " + CounterVisitor.countCommands(command) + " single commands.");
    }
}