import _socket

class IQSocket(socket.socket):
    def __init__(self, *args, **kwargs):
        super(MySocket, self).__ini__(*args, **kwargs)
        self.queue = queue.Queue

    def connect_socket(self, int, port):
        try:
