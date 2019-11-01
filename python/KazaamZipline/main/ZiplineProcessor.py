from KazaamBase.main.src.BaseProcessor import  BaseProcessor

class ZiplineProcessor(BaseProcessor):

    def __init__(self):
        super.init()

    def csv_to_bundle(self, interval='1m'):

        def ingest(environ, asset_db_writer, minute_bar_writer, daily_bar_writer, adjustment_writer, calendar,
                   start_session, end_session, cache, show_progress, output_dir, csv_dir):


            csvc_filenames = []

            ticker_pairs = [{'exchange': pair.split('_')[0],
                             'symbol': pair.split('_')[1],
                             'interval': pair.split('_')[2].split('.')[0],
                             'file_path': join(csv_data_path, pair)} for pair in csv_filenames]
