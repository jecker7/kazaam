import socket
import threading

class IQSocket(socket.socket, threading.Thread):
    def __init__(self, *args, **kwargs):
        super(IQSocket, self).__init__(*args, **kwargs)

    def run(self):
        pass

    def connect(self, host, port):
        try:
            self.bind((host, port))
            self.listen()
            conn, addr = self.accept()
            with conn:
                print("Connected by ", addr)
            while True:
                data = conn.recv(1024)
                print(data)
                if not data:
                    break
        except:
            print("Error binding to IQ Service")


    def disconnect(self):
        try:
            self.disconnect()
        except:
            print("Error disconnecting.")

    def read(self):
        while self.

if __name__ == "__main__":
    t = IQSocket()
    t.start()
    print("alive: " + t.is_alive())
