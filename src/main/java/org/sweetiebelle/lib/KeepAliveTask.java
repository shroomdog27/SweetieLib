package org.sweetiebelle.lib;

import java.sql.SQLException;

class KeepAliveTask implements Runnable {

    private ConnectionManager connection;

    KeepAliveTask(ConnectionManager connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        try {
            connection.executeQuery("SELECT 1");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
