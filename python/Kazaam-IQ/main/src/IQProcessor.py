import BaseProcessor
import IQMessage
import IQTick
import datetime

class IQProcessor(BaseProcessor):
    def process(self, message):
        iqtick = new IQTick()
        values = message.split(",")
        iqtick.timestamp = datetime.datetime.strptime(values[0], "%Y-%m-%d %H:%M.%f")
        iqmessage.body = iqtick

    def to_csv(self, message):

