

class Genie:
    class Context:
        def __init__(self):
            self._strategy = strategy

        def context_interface(self):
            self._strategy.algorithm_interface

    class BaseStrategy():
        def algorithm_interface(self):
            return

