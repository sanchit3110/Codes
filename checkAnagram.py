

def checkAnagram(self,a,b):

	letters = list(string.ascii_lowercase)

	for i in letters:
			if a[i]!=b[i]:
					return False
	return True
