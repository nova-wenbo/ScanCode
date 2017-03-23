#!/usr/bin/python
from sys import argv
import zbar
import Image
import time

if len(argv) < 2:
    print 'usgae : ./scan_imgae.py ****.png'
    exit(1)


# create a reader
scanner = zbar.ImageScanner()

# configure the reader
scanner.parse_config('enable')

# obtain image data
pil = Image.open(argv[1]).convert('L')
width, height = pil.size
raw = pil.tostring()

# wrap image data
image = zbar.Image(width, height, 'Y800', raw)

begin = time.clock()
# scan the image for barcodes
scanner.scan(image)

end = time.clock()
print 'run time :',(end - begin)*1000 ,'ms'

# extract results
for symbol in image:
    # do something useful with results
    print 'decoded', symbol.type, 'symbol', '"%s"' % symbol.data

# clean up
del(image)
