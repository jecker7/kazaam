import socket
import threading
import logging
logging.basicConfig(level=logging.INFO)
class IQSocket(socket.socket, threading.Thread):
    def __init__(self, group=None, target=None, name=None,
                 args=(), kwargs=None, verbose=None):
        super(IQSocket, self).__init__(group=group, target=target,
                                       name=name, verbose=verbose)
        self.args = args
        self.kwargs = kwargs
        return

    def run(self):
        logging.info("IQSocket Started")
        pass

    def connect(self, host, port):
        try:
            self.bind((host, port))
            self.listen()
            conn, addr = self.accept()
            with conn:
                logging.info("Connected by ", addr)
            while True:
                data = conn.recv(1024)
                logging.info(data)
                if not data:
                    break
        except:
            logging.debug("Error binding to IQ Service")

    def disconnect(self):
        try:
            self.disconnect()
        except:
            logging.debug("Error disconnecting.")

    def read(self):
        while self.

if __name__ == "__main__":
    t = IQSocket()
    t.start()
    logging.info("alive: " + t.is_alive())
