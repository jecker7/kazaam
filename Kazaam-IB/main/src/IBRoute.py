from ibapi.client import EClient
from ibapi.wrapper import EWrapper

class IBRoute(EWrapper, EClient):

    def __init__(self):
        EWrapper.__init__(self)
        EClient.__init__(self)
        self.connect(addr, port, client_id)
        self.order_id = None
        thread = Thread(target=self.run)
        thread.start()
        client = EClient(wrapper)
        client.connect("")

    def make_order(self, host, port, y, symbol, type, exchange, currency):
        client = SubmitOrder(host, port, y)
        contract = Contract()
        contract.symbol = symbol
        contract.secType = type
        contract.exchange = exchange
        contract.currency = currency

        order = Order()
        order.action = action
        order.totalQuantity = quantity
        order.orderType = order_type
        order.lmtPrice = lmt_price
        order.transmit = transmit

        client.req_ids(1)

        if client.order_id:
            client.placeOrder(client.order_id, contract, order)
        else:
            log.info("Order ID not received.")
        client.reqPositions()

    @iswrapper
    def order_status(selfself, order_id, status, filled, remaining, avg_fill_price, perm_id, parent_id,
                    last_fill_price, client_id):
        ''' Check the status of submitted order'''
        print('Number of filled positions: {}'.format(filled))
        print('Avg fill price; {}'.format(avg_fill_price))

    def get_contract_details(self, symbol, type, exchange, currency):
        contract = Contract()
        contract.symbol  = symbol
        contract.secType = type
        contract.exchange = exchange
        contract.currency = currency
        return client.reqContractDetails(1, contract)

    def connect(self, host, port):
        client = EClient(wrapper)
        client.connect(host, port, -)
        thread = Thread(target=self.run)
        thread.start()

    def main(self):



