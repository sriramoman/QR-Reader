//
//  BillModel.h
//  QR-Reader
//
//  Created by Sriram Vellangallor Subramanian on 1/23/16.
//  Copyright © 2016 Sriram Vellangallor Subramanian. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface BillModel : NSObject
@property NSString *prodDescription;
@property float price;
//Strawberry,Walmart,1011,4.09,01/23/2016
- (instancetype)initProd:(NSString *)prodDescription price:(NSString *)strPrice;
@end
