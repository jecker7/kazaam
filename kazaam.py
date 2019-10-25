import subprocess
import socket

class IQInterface():
	
	def __init__(self, client, product, user, password):
		self.client = client
		self.product = product
		self.user = user
		self.password = password
		self.connect(client, user, product, password)
		

	def connect(self, host, port, client, user, product, password):
		args = client + "-product " + product + " -version " + version \
		+ " -login " + user + " -password " + password + " -autoconnect"
		subprocess.run([client, args])

		with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
			s.bind((HOST, PORT))
			s.listen()	
			conn, addr = s.accept()
			with conn:
				print('Connected by', addr)
				while True:
					data = conn.recv(1024)
					if not data:
						break
					# handling the connection herei
					conn.sendall(data)


	def get_hticks(self, symbol, max_days, max_pts, begin, end, direction, req_id, pts_per_send):
		request = "HTX,{},{},{},{},{},{},{},{}".format(symbol, max_days, max_pts, begin, end, direction, req_iq, pts_per_send)
		return request

	def get_hdays(self, symbol, max_days, max_pts, begin, end, direction, req_id, pts_per_send):
		request = "HTD,{},{},{},{},{},{},{},{}".format(symbol, max_days, max_pts, begin, end, direction, req_iq, pts_per_send)
		return request

	def get_htime(self, symbol, begin_dt, end_dt, max_pts, begin_ft, end_ft, direction, req_id, pts_per_send):
		request = "HTT,{},{},{},{},{},{},{},{},{}".format(symbol, begin_dt, end_dt, max_pts, begin_ft, end_ft, direction, req_iq, pts_per_send)
		return request

	def get_hist_interval(self, symbol, interval, max_pts, direction, req_id, pts_per_send, interval_type, label):
		request = "HIX,{},{},{},{},{},{},{},{},{},{},{}".format(symbol, interval, interval, max_pts, direction, req_iq, pts_per_send, interval_type, label)
		return request

	def get_hist_interval_days(self, symbol, interval, max_days, max_pts, begin_ft, end_ft, direction, req_id, pts_per_send, interval_type, label):
		request = "HID,{},{},{},{},{},{},{},{},{},{},{}".format(symbol, interval, max_days, max_pts, begin_ft, end_ft, direction, req_iq, pts_per_send, interval_type, label)
		return request

	def get_hist_interval_time(self, symbol, interval, begin_dt, end_dt, max_pts, begin_ft, end_ft, direction, req_id, pts_per_send, interval_type, label):
		request = "HID,{},{},{},{},{},{},{},{},{},{},{}".format(symbol, interval, begin_dt, end_dt, max_pts, begin_ft, end_ft, direction, req_iq, pts_per_send, interval_type, label)
		return request
